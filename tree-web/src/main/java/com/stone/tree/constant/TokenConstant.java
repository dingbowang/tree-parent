package com.stone.tree.constant;

/**
 * @author dbw
 * @date 2021/01/10/11:36 下午
 * @Description
 */
public class TokenConstant {

    /**
     * token前缀
     */
    public static String BEARER="Bearer";
    /**
     * 用户账号
     */
    public static String USER_ACCOUNT="userAccount";
    /**
     * 用户Id
     */
    public static String USER_ID="userId";
    /**
     * 密码
     */
    public static String PASSWORD="password";
    /**
     * 秘钥，当然也可以把用户的密码作秘钥
     */
    public static String SECRET_KEY="dingxiang";
    /**
     * 登录方法
     */
    public static String IGNORE_LOGIN="login";
    /**
     * 过期时间
     */
    public static int TOKEN_TIME=60 * 60 * 2;
}
