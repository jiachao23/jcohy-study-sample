package com.jcohy.study.security.constans;


/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 10:44.
 * ClassName  : SecurityEnum
 * Description  : 对称算法类型
 */
public enum SymmetricEnum {
    AES("AES"),
    ARCFOUR("ARCFOUR"),
    Blowfish("Blowfish"),
    DES("DES"),
    DESede("DESede"),
    RC2("RC2"),

    PBEWithMD5AndDES("PBEWithMD5AndDES"),
    PBEWithSHA1AndDESede("PBEWithSHA1AndDESede"),
    PBEWithSHA1AndRC2_40("PBEWithSHA1AndRC2_40");

    private String value;

    private SymmetricEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}