package com.jcohy.study.security.constans;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 10:44.
 * ClassName  : SecurityEnum
 * Description  : 非对称算法类型
 */
public enum AsymmetricEnum {
    RSA("RSA"), DSA("DSA");

    private String value;

    AsymmetricEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
