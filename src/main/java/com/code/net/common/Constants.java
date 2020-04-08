package com.code.net.common;

public class Constants {
    //登录失效时间
    public static final long LOGIN_LOSE_TIME = 30;
    //用户Redis前缀
    public static final String USER_REDIS_PRE = "wsyx:user:";
    //用户token前缀
    public static final String TOKEN_REDIS_PRE = "wsyx:token:";
    //微信支付返回结果redis锁过期时间
    public static final Integer REDIS_LOCK_TIME = 3000;
    public static final String USER_REDIS_LOCK = "wsyx:wx:user_lock:";
}
