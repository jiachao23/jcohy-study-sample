package com.jcohy.study.security.constans;


/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 10:44.
 * ClassName  : SecurityEnum
 * Description  : HMAC算法类型
 */
public enum HmacEnum {
    HmacMD5("HmacMD5"),
    HmacSHA1("HmacSHA1"),
    HmacSHA256("HmacSHA256"),
    HmacSHA384("HmacSHA384"),
    HmacSHA512("HmacSHA512");

    private String value;

    private HmacEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}