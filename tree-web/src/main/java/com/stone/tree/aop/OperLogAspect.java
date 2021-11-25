package com.stone.tree.aop;

import com.alibaba.fastjson.JSON;
import com.stone.tree.annotate.OperLog;
import com.stone.tree.web.log.bean.ExceptionLog;
import com.stone.tree.web.log.bean.OperationLog;
import com.stone.tree.web.log.service.ExceptionLogService;
import com.stone.tree.web.log.service.OperationLogService;
import com.stone.tree.util.NetworkUtil;
import com.stone.tree.util.UUIDUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dbw
 * @date 2021/01/03/2:28 下午
 * @Description
 */
@Aspect
@Component
public class OperLogAspect implements Ordered {
    /**
     * 操作版本号
     * <p>
     * 项目启动时从命令行传入，例如：java -jar xxx.war --version=201902
     * </p>
     */
    //@Value("${version}")
    @Value("${version:1230}")
    private String operVer;

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private ExceptionLogService exceptionLogService;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.stone.tree.annotate.OperLog)")
    public void operLogPoinCut() {
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有service包下操作
     */
    @Pointcut("execution(* com.stone.tree.web..service..*.*(..))")
    public void operExceptionLogPoinCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        OperationLog operlog = new OperationLog();
        try {
            // 主键ID
            operlog.setId(UUIDUtil.getUUID());

            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModul = opLog.operModule();
                String operType = opLog.operType();
                String operDesc = opLog.operDesc();
                // 操作模块
                operlog.setOperModule(operModul);
                // 操作类型
                operlog.setOperType(operType);
                // 操作描述
                operlog.setOperDesc(operDesc);
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;

            // 请求方法
            operlog.setOperMethod(methodName);

            // 请求的参数
            Map<String, String> rtnMap = converMap(request.getParameterMap());
            // 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);

            // 请求参数
            operlog.setOperReqParam(params);
            // 返回结果
            operlog.setOperRespParam(JSON.toJSONString(keys));
            // 请求用户ID
            operlog.setOperUserId("UserShiroUtil.getCurrentUserLoginName()");
            // 请求用户名称
            operlog.setOperUserName("UserShiroUtil.getCurrentUserName()");
            // 请求IP
            operlog.setOperIp(NetworkUtil.getIpAddress(request));
            // 请求URI
            operlog.setOperUri(request.getRequestURI());
            // 创建时间
            operlog.setOperCreateTime(new Date());
            // 操作版本
            operlog.setOperVer(operVer);
            operationLogService.insert(operlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 非正常返回通知，拦截用户操作日志
     *
     * @param joinPoint 切入点
     */
    /*@After(value = "operLogPoinCut()")
    public void saveOperLogWithEx(JoinPoint joinPoint) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        OperationLog operlog = new OperationLog();
        try {
            operlog.setOperId(UUIDUtil.getUUID()); // 主键ID

            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModul = opLog.operModule();
                String operType = opLog.operType();
                String operDesc = opLog.operDesc();
                operlog.setOperModule(operModul); // 操作模块
                operlog.setOperType(operType); // 操作类型
                operlog.setOperDesc(operDesc); // 操作描述
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;

            operlog.setOperMethod(methodName); // 请求方法

            // 请求的参数
            Map<String, String> rtnMap = converMap(request.getParameterMap());
            // 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);

            operlog.setOperReqParam(params); // 请求参数
            operlog.setOperRespParam(""); // 返回结果
            operlog.setOperUserId("UserShiroUtil.getCurrentUserLoginName()"); // 请求用户ID
            operlog.setOperUserName("UserShiroUtil.getCurrentUserName()"); // 请求用户名称
            operlog.setOperIp(NetworkUtil.getIpAddress(request)); // 请求IP
            operlog.setOperUri(request.getRequestURI()); // 请求URI
            operlog.setOperCreateTime(new Date()); // 创建时间
            operlog.setOperVer(operVer); // 操作版本
            operationLogService.insert(operlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     *
     * @param joinPoint 切入点
     * @param e         异常信息
     */
    @AfterThrowing(pointcut = "operExceptionLogPoinCut()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        ExceptionLog excepLog = new ExceptionLog();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            excepLog.setId(UUIDUtil.getUUID());
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;
            // 请求的参数
            Map<String, String> rtnMap = converMap(request.getParameterMap());
            // 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);
            // 请求参数
            excepLog.setExcReqParam(params);
            // 请求方法名
            excepLog.setOperMethod(methodName);
            // 异常名称
            excepLog.setExcName(e.getClass().getName());
            // 异常信息
            excepLog.setExcMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()));
            // 操作员ID
            excepLog.setOperUserId("UserShiroUtil.getCurrentUserLoginName()");
            // 操作员名称
            excepLog.setOperUserName("UserShiroUtil.getCurrentUserName()");
            // 操作URI
            excepLog.setOperUri(request.getRequestURI());
            // 操作员IP
            excepLog.setOperIp(NetworkUtil.getIpAddress(request));
            // 操作版本号
            excepLog.setOperVer(operVer);
            // 发生异常时间
            excepLog.setOperCreateTime(new Date());
            exceptionLogService.insert(excepLog);

        } catch (Exception e2) {
            e2.printStackTrace();
        }

    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> converMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名称
     * @param exceptionMessage 异常信息
     * @param elements         堆栈信息
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();
        return message;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
