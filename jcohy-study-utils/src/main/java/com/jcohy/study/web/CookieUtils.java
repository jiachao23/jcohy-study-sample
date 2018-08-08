package com.jcohy.study.web;


import com.jcohy.study.common.StringUtils;
import com.jcohy.study.security.SecurityUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/9 13:29.
 * ClassName  : CookieUtils
 * Description  :
 */
public class CookieUtils {


    /**
     * 获取指定cookie
     * @param request HttpServletRequest
     * @param key key
     * @return result
     */
    public static String getCookie(HttpServletRequest request,String key){
        Map<String, Cookie> cookieMap = getCurrentRequestCookies(request);
        return cookieMap.getOrDefault(key,null).getValue();
    }

    /**
     * 从cookie中获取sessionId
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param cookieKey cookieKey
     * @return result
     */
    public static String getSessionIdFromCookie(HttpServletRequest request,HttpServletResponse response,String cookieKey){
        String cookie = getCookie(request, cookieKey);
        //cookie为空，直接清除
        if(StringUtils.isBlank(cookie)){
            removeCookie(response,cookieKey);
            return null;
        }
        //解密cookie
        String cookieValue = SecurityUtils.aes().decrypt(cookie.getBytes()).toString();
        String[] sessionValue = cookieValue.split("~");
        // 3.异常或解密问题，直接清除cookie信息
        if (StringUtils.isBlank(cookieValue)) {
            removeCookie(response, cookieKey);
            return null;
        }

        // 4.规则不匹配
        if (sessionValue.length != 4) {
            removeCookie(response, cookieKey);
            return null;
        }

        String sessionId   = sessionValue[0];
        String oldTime  = sessionValue[1];
        String maxAge   = sessionValue[2];
        // 5.判定时间区间，超时的cookie清理掉
        long now  = System.currentTimeMillis();
        long time = Long.parseLong(oldTime) + (Long.parseLong(maxAge) * 1000);
        if (time <= now) {
            removeCookie(response, cookieKey);
            return null;
        }
        return sessionId;
    }

    /**
     * 设置cookie
     * @param response HttpServletResponse
     * @param name name
     * @param value value
     * @param maxAgeInSeconds time
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setHttpOnly(false);
        response.addCookie(cookie);
    }

    /**
     * 设置cookie
     * @param response HttpServletResponse
     * @param name name
     * @param value value
     * @param httpOnly httpOnly
     * @param maxAgeInSeconds time
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds,boolean httpOnly) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setHttpOnly(httpOnly);
        response.addCookie(cookie);
    }

    /**
     * 设置cookie
     * @param response HttpServletResponse
     * @param name name
     * @param value value
     * @param httpOnly httpOnly
     * @param domain domain
     * @param maxAgeInSeconds time
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds,boolean httpOnly,String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setHttpOnly(httpOnly);
        cookie.setDomain(domain);
        response.addCookie(cookie);
    }

    /**
     * cookie设计为: des(私钥).encode(sessionId~time~maxAge~ip)
     * @param response  response
     * @param cookieKey  cookie名称
     * @param sessionId  用户sessionId
     * @param loginIp 登录Ip
     * @param maxAge   session失效时间
     */
    public static void setSessionId2Cookie(HttpServletResponse response,String cookieKey, String sessionId, String loginIp, int maxAge){
        long now  = System.currentTimeMillis();
        // 构造cookie
        StringBuilder cookieBuilder = new StringBuilder()
                .append(sessionId).append("~")
                .append(now).append("~")
                .append(maxAge).append("~")
                .append(loginIp);


        // cookie 私钥 加密cookie
        String userCookie = (SecurityUtils.aes().encrypt(cookieBuilder.toString())).toString();
        // 设置用户的cookie、 -1 维持成session的状态
        setCookie(response, cookieKey, userCookie, maxAge);
    }

    /**
     * 清除 某个指定的cookie
     * @param response HttpServletResponse
     * @param key key
     */
    public static void removeCookie(HttpServletResponse response,String key){
        setCookie(response, key, null, 0);
    }

    /**
     * 获取当前请求的所有cookie
     * @param request HttpServletRequest
     * @return mapCookie
     */
    public static Map<String, Cookie> getCurrentRequestCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Map<String,Cookie> map = new HashMap<>();
        Arrays.stream(cookies).forEach(c -> map.put(c.getName(),c));
        return map;
    }


}
