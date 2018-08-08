package com.jcohy.study.security.AsymmetricAlgorithm;



import com.jcohy.study.security.Encrypt;
import com.jcohy.study.security.SecurityUtils;
import com.jcohy.study.security.constans.AsymmetricEnum;
import com.jcohy.study.security.constans.KeyType;
import com.jcohy.study.security.exception.EncryptException;
import com.jcohy.study.security.zsupport.FastByteArrayOutputStream;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 非对称加密算法<br>
 * 1、签名：使用私钥加密，公钥解密。用于让所有公钥所有者验证私钥所有者的身份并且用来防止私钥所有者发布的内容被篡改，但是不用来保证内容不被他人获得。<br>
 * 2、加密：用公钥加密，私钥解密。用于向公钥所有者发布信息,这个信息可能被他人篡改,但是无法被他人获得。
 *
 * @author Looly
 */
public class AsymmetricEncryption {

    /**
     * 算法
     */
    protected String algorithm;
    /**
     * 公钥
     */
    protected PublicKey publicKey;
    /**
     * 私钥
     */
    protected PrivateKey privateKey;
    /**
     * Cipher负责完成加密或解密工作
     */
    protected Cipher clipher;
    /**
     * 签名，用于签名和验证
     */
    protected Signature signature;

    protected Lock lock = new ReentrantLock();

    // ------------------------------------------------------------------ Constructor start

    /**
     * 构造，创建新的私钥公钥对
     * @param algorithm 算法
     */
    public AsymmetricEncryption(AsymmetricEnum algorithm) {
        this(algorithm, null, null);
    }

    /**
     * 构造，创建新的私钥公钥对
     *
     * @param algorithm 算法
     */
    public AsymmetricEncryption(String algorithm) {
        this(algorithm, null, null);
    }

    /**
     * 构造
     * 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
     * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
     *
     * @param algorithm  {@link AsymmetricEnum}
     * @param privateKey 私钥
     * @param publicKey  公钥
     */
    public AsymmetricEncryption(AsymmetricEnum algorithm, byte[] privateKey, byte[] publicKey) {
        this(algorithm.getValue(), privateKey, publicKey);
    }

    /**
     * 构造
     * <p>
     * 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
     * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密
     *
     * @param algorithm  算法
     * @param privateKey 私钥
     * @param publicKey  公钥
     */
    public AsymmetricEncryption(String algorithm, byte[] privateKey, byte[] publicKey) {
        init(algorithm, privateKey, publicKey);
    }
    // ------------------------------------------------------------------ Constructor end

    /**
     * 初始化<br>
     * 私钥和公钥同时为空时生成一对新的私钥和公钥<br>
     * 私钥和公钥可以单独传入一个，如此则只能使用此钥匙来做加密或者解密<br>
     * 签名默认使用MD5摘要算法，如果需要自定义签名算法，调用 {@link AsymmetricEncryption#setSignature(Signature)}设置签名对象
     *
     * @param algorithm  算法
     * @param privateKey 私钥
     * @param publicKey  公钥
     * @return {@link AsymmetricEncryption}
     */
    public AsymmetricEncryption init(String algorithm, byte[] privateKey, byte[] publicKey) {
        this.algorithm = algorithm;
        try {
            this.clipher = Cipher.getInstance(algorithm);
            this.signature = Signature.getInstance("MD5with" + algorithm);//默认签名算法
        } catch (Exception e) {
            throw new EncryptException(e);
        }

        if (null == privateKey && null == publicKey) {
            initKeys();
        } else {
            if (null != privateKey) {
                this.privateKey = SecurityUtils.generatePrivateKey(algorithm, privateKey);
            }
            if (null != publicKey) {
                this.publicKey = SecurityUtils.generatePublicKey(algorithm, publicKey);
            }
        }
        return this;
    }

    /**
     * 生成公钥和私钥
     * @return result
     */
    public AsymmetricEncryption initKeys() {
        KeyPair keyPair = SecurityUtils.generateKeyPair(this.algorithm);
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
        return this;
    }

    // --------------------------------------------------------------------------------- Sign and Verify

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data 加密数据
     * @return 签名
     */
    public byte[] sign(byte[] data) {
        try {
            signature.initSign(this.privateKey);
            signature.update(data);
            return signature.sign();
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    /**
     * 用公钥检验数字签名的合法性
     *
     * @param data 数据
     * @param sign 签名
     * @return 是否验证通过
     */
    public boolean verify(byte[] data, byte[] sign) {
        try {
            signature.initVerify(this.publicKey);
            signature.update(data);
            return signature.verify(sign);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    // --------------------------------------------------------------------------------- Encrypt

    /**
     * 加密
     *
     * @param data    被加密的bytes
     * @param keyType 私钥或公钥 {@link KeyType}
     * @return 加密后的bytes
     */
    public byte[] encrypt(byte[] data, KeyType keyType) {
        lock.lock();
        try {
            clipher.init(Cipher.ENCRYPT_MODE, getKeyByType(keyType));
            return clipher.doFinal(data);

        } catch (Exception e) {
            throw new EncryptException(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 加密
     *
     * @param data    被加密的字符串
     * @param charset 编码
     * @param keyType 私钥或公钥 {@link KeyType}
     * @return 加密后的bytes
     */
    public byte[] encrypt(String data, String charset, KeyType keyType) {
        if (data == null) {
            return null;
        }
        return encrypt(charset == null || charset.length() == 0 ? data.getBytes() : data.getBytes(Charset.forName(charset)), keyType);
    }

    /**
     * 加密，使用UTF-8编码
     *
     * @param data    被加密的字符串
     * @param keyType 私钥或公钥 {@link KeyType}
     * @return 加密后的bytes
     */
    public byte[] encrypt(String data, KeyType keyType) {
        if (data == null) {
            return null;
        }
        return encrypt(data.getBytes(Charset.forName(StandardCharsets.UTF_8.name())), keyType);
    }

    /**
     * 加密
     *
     * @param data    被加密的字符串
     * @param keyType 私钥或公钥 {@link KeyType}
     * @return 加密后的bytes
     */
    public byte[] encrypt(InputStream data, KeyType keyType) {
        try {
            return encrypt(readBytes(data), keyType);
        } catch (IOException e) {
            throw new EncryptException(e);
        }
    }

    // --------------------------------------------------------------------------------- Decrypt

    /**
     * 解密
     *
     * @param bytes   被解密的bytes
     * @param keyType 私钥或公钥 {@link KeyType}
     * @return 解密后的bytes
     */
    public byte[] decrypt(byte[] bytes, KeyType keyType) {
        lock.lock();
        try {
            clipher.init(Cipher.DECRYPT_MODE, getKeyByType(keyType));
            return clipher.doFinal(bytes);
        } catch (Exception e) {
            throw new EncryptException(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 解密
     *
     * @param data    被解密的bytes
     * @param keyType 私钥或公钥 {@link KeyType}
     * @return 解密后的bytes
     */
    public byte[] decrypt(InputStream data, KeyType keyType) {
        try {
            return decrypt(readBytes(data), keyType);
        } catch (IOException e) {
            throw new EncryptException(e);
        }
    }

    // --------------------------------------------------------------------------------- Getters and Setters

    /**
     * 获得公钥
     *
     * @return 获得公钥
     */
    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    /**
     * 获得公钥
     *
     * @return 获得公钥
     */
    public String getPublicKeyBase64() {
        return Encrypt.base64.encode(getPublicKey().getEncoded());
    }

    /**
     * 设置公钥
     *
     * @param publicKey 公钥
     * @return 自身 {@link AsymmetricEncryption}
     */
    public AsymmetricEncryption setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * 获得私钥
     *
     * @return 获得私钥
     */
    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    /**
     * 获得私钥
     *
     * @return 获得私钥
     */
    public String getPrivateKeyBase64() {
        return Encrypt.base64.encode(getPrivateKey().getEncoded());
    }

    /**
     * 设置私钥
     *
     * @param privateKey 私钥
     * @return 自身 {@link AsymmetricEncryption}
     */
    public AsymmetricEncryption setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * 获得签名对象
     *
     * @return {@link Signature}
     */
    public Signature getSignature() {
        return signature;
    }

    /**
     * 设置签名
     *
     * @param signature 签名对象 {@link Signature}
     * @return 自身 {@link AsymmetricEncryption}
     */
    public AsymmetricEncryption setSignature(Signature signature) {
        this.signature = signature;
        return this;
    }

    /**
     * 获得加密或解密器
     *
     * @return 加密或解密
     */
    public Cipher getClipher() {
        return clipher;
    }

    /**
     * 根据密钥类型获得相应密钥
     *
     * @param type 类型 {@link KeyType}
     * @return {@link Key}
     */
    protected Key getKeyByType(KeyType type) {
        switch (type) {
            case PrivateKey:
                if (null == this.privateKey) {
                    throw new NullPointerException("Private key must not null when use it !");
                }
                return this.privateKey;
            case PublicKey:
                if (null == this.publicKey) {
                    throw new NullPointerException("Public key must not null when use it !");
                }
                return this.publicKey;
        }
        throw new EncryptException("Unknown key type: " + type);
    }

    /**
     * 从流中读取bytes
     *
     * @param #data {@link InputStream}
     * @return bytes
     * @throws IOException
     */
    private static byte[] readBytes(InputStream data) throws IOException {
        final FastByteArrayOutputStream out = new FastByteArrayOutputStream();
        if (null == data) {
            throw new NullPointerException("InputStream is null!");
        }
        if (null == out) {
            throw new NullPointerException("OutputStream is null!");
        }
        byte[] buffer = new byte[1024];
        for (int readSize; (readSize = data.read(buffer)) != -1; ) {
            out.write(buffer, 0, readSize);
            out.flush();
        }
        return out.toByteArray();
    }
}
