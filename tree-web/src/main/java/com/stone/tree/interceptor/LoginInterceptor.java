package com.stone.tree.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dbw
 * @date 2021/01/04/11:08 下午
 * @Description test for demo
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*if(Objects.isNull(request.getSession().getAttribute("userInfo"))){
            response.setStatus(RetCode.FAIL.code);
            return false;
        }else{
            return true;
        }*/
        return true;
    }
}
