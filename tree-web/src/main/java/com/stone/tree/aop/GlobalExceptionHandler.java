package com.stone.tree.aop;

import com.stone.tree.enums.RetCode;
import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dbw
 * @date 2021/01/03/9:57 下午
 * @Description 自定义异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ServiceException.class)
    public RetResult exceptionHandler(HttpServletRequest req, ServiceException e){
        logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return RetResponse.makeRsp(e.errorCode == null ? RetCode.FAIL.code : e.errorCode,e.getErrorMsg(),null);
    }

    @ExceptionHandler(value = Exception.class)
    public RetResult exceptionHandler(HttpServletRequest req, Exception e){

        logger.error(e.getMessage(),e);
        return RetResponse.makeRsp(RetCode.FAIL.code,"系统内部异常",null);
    }
}
