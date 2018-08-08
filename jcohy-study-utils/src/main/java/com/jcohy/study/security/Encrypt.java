package com.jcohy.study.security;


import com.jcohy.study.security.DigestAlgorithm.DigestFactory;
import com.jcohy.study.security.base64.Base32;
import com.jcohy.study.security.base64.Base64;
import com.jcohy.study.security.hmac.HexFactory;
import com.jcohy.study.security.url.UrlFactory;

/**
 * 对称和非对称加密请使用SecurityUtils或者单独的AsymmetricEncryption和SymmetricEncryption
 *
 */
public interface Encrypt {

    /**
     * 摘要加密
     */
    DigestFactory digest = new DigestFactory();

    /**
     * hex
     */
    HexFactory hex = new HexFactory();


    /**
     * Base64的编码和解码方案
     */
    Base64 base64 = new Base64();

    /**
     * 提供Base32的编码和解码
     */
    Base32 base32 = new Base32();

    /**
     * url编码解码
     */
    UrlFactory url = new UrlFactory();

    /**
     * 安全工具类，主要针对常用加密算法构建快捷方式，还有提供一些密钥生成的快捷工具方法。
     * 详细请查看<a href="http://hutool.mydoc.io/?t=216008">Hutool</a>
     */
    SecurityUtils secyrityFactory = new SecurityUtils();

}
