package com.stone.tree.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.stone.tree.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @author dbw
 * @date 2021/01/04/11:08 下午
 * @Description test for demo
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            return false;
        }
        //根据token拿到userId
        DecodedJWT decode = JWT.decode(token);
        Map<String, Claim> claims = decode.getClaims();
        String userId = claims.get("userId").asString();
        if(StringUtils.isBlank(userId)){
            logger.info("checkToken [{}]",userId);
            return false;
        }
        //查询redis中的token
        Object obj = redisUtil.get(userId);
        if(Objects.isNull(obj)){
            logger.info("redis未查询到对应token [{}]",userId);
            return false;
        }
        //比对redis与传入的token值
        if(!obj.toString().equals(token)){
            logger.info("redis与传入token不相等 {}::{}",token,userId);
            return false;
        }
        return true;
    }
}
