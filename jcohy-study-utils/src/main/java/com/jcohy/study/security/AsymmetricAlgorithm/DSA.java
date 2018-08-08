package com.jcohy.study.security.AsymmetricAlgorithm;


import com.jcohy.study.security.constans.AsymmetricEnum;

/**
 * DSA加密算法
 *
 * @author Looly
 */
public class DSA extends AsymmetricEncryption {

    private static final AsymmetricEnum ALGORITHM_DSA = AsymmetricEnum.DSA;

    // ------------------------------------------------------------------ Constructor start

    /**
     * 构造，创建新的私钥公钥对
     */
    public DSA() {
        super(ALGORITHM_DSA);
    }

    /**
     * 构造 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
     * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
     *
     * @param privateKey 私钥
     * @param publicKey  公钥
     */
    public DSA(byte[] privateKey, byte[] publicKey) {
        super(ALGORITHM_DSA, privateKey, publicKey);
    }
    // ------------------------------------------------------------------ Constructor end
}
