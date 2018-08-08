package com.jcohy.study.security.constans;


/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 10:44.
 * ClassName  : SecurityEnum
 * Description  : 摘要算法类型
 */
public enum DigestEnum {
    MD2("MD2"),
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA384("SHA-384"),
    SHA512("SHA-512");

    private String value;

    private DigestEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}