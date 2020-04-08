package com.code.net.common;

public class Constants {
    //默认分页每页的数量
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    //登录失效时间
    public static final long LOGIN_LOSE_TIME = 30;
    //用户Redis前缀
    public static final String USER_REDIS_PRE = "wsyx:user:";
    //用户token前缀
    public static final String TOKEN_REDIS_PRE = "wsyx:token:";
    //后台用户Redis前缀
    public static final String MANAGE_REDIS_PRE = "wsyx:manage:";
    //用户手机号验证码Redis前缀
    public static final String SMS_REDIS_PRE = "wsyx:sms:";
    //用户手机号验证码失效时长(分钟)
    public static final long SMS_REDIS_LOST_TIME = 10;
    //用户配置
    public static final String CONFIG_REDIS_PRE = "wsyx:config";
    //用户配置
    public static final String CONFIG_REDIS_PRE1 = "wsyx:config";
    //字典表DictType
    public static final String DICT_REDIS_PRE = "wsyx:dict";
    //热搜词
    public static final String HOT_KEY="wsyx:hotkey";
    //支付key
    public static final String PAY_KEY = "0280dba7758f47d9a6ef764bd31143e8";
    //广告
    public static final String DICT_AD="wsyx:ad";
    //微信支付调用结果collection名称
    public static final String ORDER_START = "wsyx:wx:order_start:";
    //微信支付返回结果collection名称
    public static final String ORDER_RESULT = "wsyx:wx:order_result:";
    //微信支付返回结果redis锁前缀
    public static final String REDIS_LOCK_PRE = "wsyx:wx:order_lock:";
    public static final String REDIS_VIP_LOCK_PRE = "wsyx:wx:vip_lock:";
    //微信支付返回结果redis锁过期时间
    public static final Integer REDIS_LOCK_TIME = 3000;
    public static final String USER_REDIS_LOCK = "wsyx:wx:user_lock:";
    //签名图片临时存储文件夹
    public static final String TMP_IMG_FOLDER = "tmp_sign_img";
    //accessToken存储redis的key
    public static final String ACCESS_TOKEN_PRE = "wsyx:access_token";
    //存储或获取formId的redis锁前缀
    public static final String FORM_LOCK_PRE = "wsyx:form_id:lock:";
    //存储formId的redis前缀
    public static final String FORM_REDIS_PRE = "wsyx:form_id:save:";
}
