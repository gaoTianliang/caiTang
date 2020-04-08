package com.code.net.controller;

import com.alibaba.fastjson.JSONObject;
import com.code.net.common.Constants;
import com.code.net.common.RedisLock;
import com.code.net.common.RedisService;
import com.code.net.pojo.dto.LoginDTO;
import com.code.net.pojo.vo.WsyxUserVO;
import com.code.net.util.CookieUtils;
import com.code.net.util.HttpRequestUtils;
import com.code.net.util.JwtHelper;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author gtl
 * @version 1.0
 * @date 2019/11/19 15:51
 */
public class WxLoginController {

    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.userAppSecret}")
    private String userAppSecret;

    @Autowired
    private RedisLock redisLock;
    @Resource
    private RedisService redisService;

    public void login(LoginDTO loginDTO, HttpServletResponse response) {
        //获取微信登录URL
        String wxLoginUrlConfig = "";
        JSONObject json = JSONObject.parseObject(wxLoginUrlConfig);
        String wxLoginUrl = json.get("wx_login_url").toString();
        String param = "appid=" + appId + "&secret=" + userAppSecret + "&js_code=" + loginDTO.getCode() + "&grant_type=authorization_code";
        String loginResult = HttpRequestUtils.sendGet(wxLoginUrl, param);
        if (StringUtils.isNotBlank(loginResult)) {
            JSONObject loginJson = JSONObject.parseObject(loginResult);
            if (!StringUtils.equals(loginJson.getString("errcode"), "40029")
                    && !StringUtils.equals(loginJson.getString("errcode"), "45011")
                    && !StringUtils.equals(loginJson.getString("errcode"), "-1")) {
                String userId = "";
                //微信授权成功
                WsyxUserVO user = new WsyxUserVO();
                user.setOpenid(loginJson.getString("openid"));
                if (StringUtils.isNotBlank(loginJson.getString("unionid"))) {
                    user.setUnid(loginJson.getString("unionid"));
                }
                user.setDelFlag("1");

                if (redisLock.lock(Constants.USER_REDIS_LOCK, loginJson.getString("openid"))) {
                    try {
                        //新用户插入,老用户查询
                        //返回token
                        Map<String, String> map = Maps.newHashMap();
                        map.put("id", userId);
                        map.put("userType", "customer");
                        String token = JwtHelper.genToken(map);
                        map.put("token", token);
                        redisService.set(Constants.TOKEN_REDIS_PRE + token, loginJson, Constants.LOGIN_LOSE_TIME, TimeUnit.MINUTES);
                        redisService.set(Constants.USER_REDIS_PRE + userId, new User());
                        CookieUtils.setCookie(response, "x-token", token);
                        response.setHeader("x-token", token);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        redisLock.delete(Constants.USER_REDIS_LOCK + loginJson.getString("openid"));
                    }
                } else {
                    System.out.println("获取用户信息失败");
                }
            } else {
                System.out.println("微信授权失败");
            }
        } else {
            System.out.println("微信授权失败");
        }

    }
}
