package com.jcohy.study.security;


import com.jcohy.study.security.DigestAlgorithm.DigestAlgorithm;
import com.jcohy.study.security.SymmetricAlgorithm.SymmetricEncryption;
import com.jcohy.study.security.constans.AsymmetricEnum;
import com.jcohy.study.security.constans.DigestEnum;
import com.jcohy.study.security.constans.HmacEnum;
import com.jcohy.study.security.constans.SymmetricEnum;
import com.jcohy.study.security.exception.EncryptException;
import com.jcohy.study.security.hmac.HMac;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 11:25.
 * ClassName  : SecurityUtils
 * Description  :
 */
public class SecurityUtils {

    /**
     * 默认密钥字节数
     * RSA/DSA
     * Default Keysize 1024
     * Keysize must be a multiple of 64, ranging from 512 to 1024 (inclusive).
     */
    public static final int DEFAULT_KEY_SIZE = 1024;

    /**
     * 生成 {@link SecretKey}
     * @param algorithm 算法，支持PBE算法
     * @return {@link SecretKey}
     */
    public static SecretKey generateKey(String algorithm) {
        SecretKey secretKey;
        try {
            secretKey = KeyGenerator.getInstance(algorithm).generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptException(e);
        }
        return secretKey;
    }

    /**
     * 生成 {@link SecretKey}
     *
     * @param algorithm 算法
     * @param key       密钥
     * @return {@link SecretKey}
     */
    public static SecretKey generateKey(String algorithm, byte[] key) {
        if (algorithm == null || algorithm.length() == 0 || algorithm.trim().length() == 0) {
            throw new IllegalArgumentException("Algorithm is blank!");
        }
        SecretKey secretKey;
        if (algorithm.startsWith("PBE")) {
            // PBE密钥
            secretKey = generatePBEKey(algorithm, (null == key) ? null : new String(key, StandardCharsets.UTF_8).toCharArray());
        } else if (algorithm.startsWith("DES")) {
            // DES密钥
            secretKey = generateDESKey(algorithm, key);
        } else {
            // 其它算法密钥
            secretKey = (null == key) ? generateKey(algorithm) : new SecretKeySpec(key, algorithm);
        }
        return secretKey;
    }

    /**
     * 生成 {@link SecretKey}
     *
     * @param algorithm PBE算法
     * @param key       密钥
     * @return {@link SecretKey}
     */
    public static SecretKey generateDESKey(String algorithm, byte[] key) {
        if (algorithm == null || algorithm.length() == 0 || algorithm.trim().length() == 0 || false == algorithm.startsWith("DES")) {
            throw new EncryptException("Algorithm is not a DES algorithm!");
        }
        SecretKey secretKey;
        if (null == key) {
            secretKey = generateKey(algorithm);
        } else {
            DESKeySpec keySpec;
            try {
                keySpec = new DESKeySpec(key);
            } catch (InvalidKeyException e) {
                throw new EncryptException(e);
            }
            secretKey = generateKey(algorithm, keySpec);
        }
        return secretKey;
    }

    /**
     * 生成PBE {@link SecretKey}
     *
     * @param algorithm PBE算法
     * @param key       密钥
     * @return {@link SecretKey}
     */
    public static SecretKey generatePBEKey(String algorithm, char[] key) {
        if (algorithm == null || algorithm.length() == 0 || algorithm.trim().length() == 0 || false == algorithm.startsWith("PBE")) {
            throw new EncryptException("Algorithm is not a PBE algorithm!");
        }

        if (null == key) {
            key = randomString("0123456789abcdefghijklmnopqrstuvwxyz", 32).toCharArray();
        }
        PBEKeySpec keySpec = new PBEKeySpec(key);
        return generateKey(algorithm, keySpec);
    }

    /**
     * 生成 {@link SecretKey}
     *
     * @param algorithm 算法
     * @param keySpec   {@link KeySpec}
     * @return {@link SecretKey}
     */
    public static SecretKey generateKey(String algorithm, KeySpec keySpec) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
            return keyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    /**
     * 生成私钥
     *
     * @param algorithm 算法
     * @param key       密钥
     * @return 私钥 {@link PrivateKey}
     */
    public static PrivateKey generatePrivateKey(String algorithm, byte[] key) {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        try {
            return KeyFactory.getInstance(algorithm).generatePrivate(pkcs8KeySpec);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    /**
     * 生成私钥
     *
     * @param keyStore {@link KeyStore}
     * @param alias    别名
     * @param password 密码
     * @return 私钥 {@link PrivateKey}
     */
    public static PrivateKey generatePrivateKey(KeyStore keyStore, String alias, char[] password) {
        try {
            return (PrivateKey) keyStore.getKey(alias, password);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    /**
     * 生成公钥
     *
     * @param algorithm 算法
     * @param key       密钥
     * @return 公钥 {@link PublicKey}
     */
    public static PublicKey generatePublicKey(String algorithm, byte[] key) {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        try {
            return KeyFactory.getInstance(algorithm).generatePublic(x509KeySpec);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    /**
     * 生成用于非对称加密的公钥和私钥
     *
     * @param algorithm 非对称加密算法
     * @return {@link KeyPair}
     */
    public static KeyPair generateKeyPair(String algorithm) {
        return generateKeyPair(algorithm, DEFAULT_KEY_SIZE, null);
    }

    /**
     * 生成用于非对称加密的公钥和私钥
     *
     * @param algorithm 非对称加密算法
     * @param keySize   密钥模（modulus ）长度
     * @return {@link KeyPair}
     */
    public static KeyPair generateKeyPair(String algorithm, int keySize) {
        return generateKeyPair(algorithm, keySize, null);
    }

    /**
     * 生成用于非对称加密的公钥和私钥
     *
     * @param algorithm 非对称加密算法
     * @param keySize   密钥模（modulus ）长度
     * @param seed      种子
     * @return {@link KeyPair}
     */
    public static KeyPair generateKeyPair(String algorithm, int keySize, byte[] seed) {
        KeyPairGenerator keyPairGen;
        try {
            keyPairGen = KeyPairGenerator.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptException(e);
        }

        if (keySize <= 0) {
            keySize = DEFAULT_KEY_SIZE;
        }
        if (null != seed) {
            SecureRandom random = new SecureRandom(seed);
            keyPairGen.initialize(keySize, random);
        } else {
            keyPairGen.initialize(keySize);
        }
        return keyPairGen.generateKeyPair();
    }

    /**
     * 生成签名对象
     *
     * @param asymmetricAlgorithm {@link AsymmetricEnum} 非对称加密算法
     * @param digestAlgorithm     {@link DigestAlgorithm} 摘要算法
     * @return {@link Signature}
     */
    public static Signature generateSignature(AsymmetricEnum asymmetricAlgorithm, DigestEnum digestAlgorithm) {
        String digestPart = (null == digestAlgorithm) ? "NONE" : digestAlgorithm.name();
        String algorithm = digestPart + "with" + asymmetricAlgorithm.getValue();
        try {
            return Signature.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptException(e);
        }
    }

    /**
     * 读取密钥库(Java Key Store，JKS) KeyStore文件<br>
     * KeyStore文件用于数字证书的密钥对保存<br>
     * see: http://snowolf.iteye.com/blog/391931
     *
     * @param in       {@link InputStream} 如果想从文件读取.keystore文件，使用<code>new BufferedInputStream(new FileInputStream(file));</code>读取
     * @param password 密码
     * @return {@link KeyStore}
     */
    public static KeyStore readJKSKeyStore(InputStream in, char[] password) {
        return readKeyStore("JKS", in, password);
    }

    /**
     * 读取KeyStore文件<br>
     * KeyStore文件用于数字证书的密钥对保存<br>
     * see: http://snowolf.iteye.com/blog/391931
     *
     * @param type     类型
     * @param in       {@link InputStream} 如果想从文件读取.keystore文件，使用<code>new BufferedInputStream(new FileInputStream(file));</code>读取
     * @param password 密码
     * @return {@link KeyStore}
     */
    public static KeyStore readKeyStore(String type, InputStream in, char[] password) {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance(type);
            keyStore.load(in, password);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
        return keyStore;
    }

    /**
     * 读取X.509 Certification文件<br>
     * Certification为证书文件<br>
     * see: http://snowolf.iteye.com/blog/391931
     *
     * @param in       {@link InputStream} 如果想从文件读取.cer文件，使用<code>new BufferedInputStream(new FileInputStream(file));</code>读取
     * @param password 密码
     * @return {@link KeyStore}
     */
    public static Certificate readX509Certificate(InputStream in, char[] password) {
        return readCertificate("X.509", in, password);
    }

    /**
     * 读取Certification文件<br>
     * Certification为证书文件<br>
     * see: http://snowolf.iteye.com/blog/391931
     *
     * @param type     类型
     * @param in       {@link InputStream} 如果想从文件读取.cer文件，使用<code>new BufferedInputStream(new FileInputStream(file));</code>读取
     * @param password 密码
     * @return {@link KeyStore}
     */
    public static Certificate readCertificate(String type, InputStream in, char[] password) {
        Certificate certificate;
        try {
            certificate = CertificateFactory.getInstance(type).generateCertificate(in);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
        return certificate;
    }

    /**
     * 获得 Certification
     *
     * @param keyStore {@link KeyStore}
     * @param alias    别名
     * @return {@link Certificate}
     */
    public static Certificate getCertificate(KeyStore keyStore, String alias) {
        try {
            return keyStore.getCertificate(alias);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
    }

    // ------------------------------------------------------------------- 对称加密算法

    /**
     * AES加密，生成随机KEY。注意解密时必须使用相同 {@link SymmetricEncryption}对象或者使用相同KEY<br>
     * 例：<br>
     * AES加密：aes().encrypt(data)<br>
     * AES解密：aes().decrypt(data)<br>
     *
     * @return {@link SymmetricEncryption}
     */
    public static SymmetricEncryption aes() {
        return new SymmetricEncryption(SymmetricEnum.AES);
    }

    /**
     * AES加密<br>
     * 例：<br>
     * AES加密：aes(key).encrypt(data)<br>
     * AES解密：aes(key).decrypt(data)<br>
     *
     * @param key 密钥
     * @return {@link SymmetricEncryption}
     */
    public static SymmetricEncryption aes(byte[] key) {
        return new SymmetricEncryption(SymmetricEnum.AES, key);
    }

    /**
     * DES加密，生成随机KEY。注意解密时必须使用相同 {@link SymmetricEncryption}对象或者使用相同KEY<br>
     * 例：<br>
     * DES加密：des().encrypt(data)<br>
     * DES解密：des().decrypt(data)<br>
     *
     * @return {@link SymmetricEncryption}
     */
    public static SymmetricEncryption des() {
        return new SymmetricEncryption(SymmetricEnum.DES);
    }

    /**
     * DES加密<br>
     * 例：<br>
     * DES加密：des(key).encrypt(data)<br>
     * DES解密：des(key).decrypt(data)<br>
     *
     * @param key 密钥
     * @return {@link SymmetricEncryption}
     */
    public static SymmetricEncryption des(byte[] key) {
        return new SymmetricEncryption(SymmetricEnum.DES, key);
    }

    // ------------------------------------------------------------------- 摘要算法

    /**
     * MD5加密<br>
     * 例：<br>
     * MD5加密：md5().digest(data)<br>
     * MD5加密并转为16进制字符串：md5().digestHex(data)<br>
     *
     * @return {@link DigestAlgorithm}
     */
    public static DigestAlgorithm md5() {
        return new DigestAlgorithm(DigestEnum.MD5);
    }

    /**
     * MD5加密，生成16进制MD5字符串<br>
     * @param data 数据
     * @return MD5字符串
     */
    public static String md5(String data) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(data);
    }

    /**
     * MD5加密，生成16进制MD5字符串<br>
     * @param data 数据
     * @return MD5字符串
     */
    public static String md5(InputStream data) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(data);
    }

    /**
     * MD5加密文件，生成16进制MD5字符串<br>
     * @param dataFile 文件数据
     * @return MD5字符串
     */
    public static String md5(File dataFile) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(dataFile);
    }

    /**
     * SHA1加密<br>
     * 例：<br>
     * SHA1加密：sha1().digest(data)<br>
     * SHA1加密并转为16进制字符串：sha1().digestHex(data)<br>
     *
     * @return {@link DigestAlgorithm}
     */
    public static DigestAlgorithm sha1() {
        return new DigestAlgorithm(DigestEnum.SHA1);
    }

    /**
     * SHA1加密，生成16进制SHA1字符串<br>
     * @param data 数据
     * @return SHA1字符串
     */
    public static String sha1(String data) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(data);
    }

    /**
     * SHA1加密，生成16进制SHA1字符串<br>
     * @param data 数据
     * @return SHA1字符串
     */
    public static String sha256(String data) {
        return new DigestAlgorithm(DigestEnum.SHA256).digestHex(data);
    }

    /**
     * SHA1加密，生成16进制SHA1字符串<br>
     * @param data 数据
     * @return SHA1字符串
     */
    public static String sha1(InputStream data) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(data);
    }

    /**
     * SHA1加密文件，生成16进制SHA1字符串<br>
     * @param dataFile 文件数据
     * @return SHA1字符串
     */
    public static String sha1(File dataFile) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(dataFile);
    }

    /**
     * HmacMD5加密器<br>
     * 例：<br>
     * HmacMD5加密：hmacMd5(key).digest(data)<br>
     * HmacMD5加密并转为16进制字符串：hmacMd5(key).digestHex(data)<br>
     *
     * @param key 加密密钥
     * @return {@link HMac}
     */
    public static HMac hmacMd5(byte[] key) {
        return new HMac(HmacEnum.HmacMD5, key);
    }

    /**
     * HmacMD5加密器，生成随机KEY<br>
     * 例：<br>
     * HmacMD5加密：hmacMd5().digest(data)<br>
     * HmacMD5加密并转为16进制字符串：hmacMd5().digestHex(data)<br>
     *
     * @return {@link HMac}
     */
    public static HMac hmacMd5() {
        return new HMac(HmacEnum.HmacMD5);
    }

    /**
     * HmacSHA1加密器<br>
     * 例：<br>
     * HmacSHA1加密：hmacSha1(key).digest(data)<br>
     * HmacSHA1加密并转为16进制字符串：hmacSha1(key).digestHex(data)<br>
     *
     * @param key 加密密钥
     * @return {@link HMac}
     */
    public static HMac hmacSha1(byte[] key) {
        return new HMac(HmacEnum.HmacSHA1, key);
    }

    /**
     * HmacSHA1加密器，生成随机KEY<br>
     * 例：<br>
     * HmacSHA1加密：hmacSha1().digest(data)<br>
     * HmacSHA1加密并转为16进制字符串：hmacSha1().digestHex(data)<br>
     *
     * @return {@link HMac}
     */
    public static HMac hmacSha1() {
        return new HMac(HmacEnum.HmacSHA1);
    }

    /**
     * 获得一个随机的字符串
     *
     * @param baseString 随机字符选取的样本
     * @param length     字符串的长度
     * @return 随机字符串
     */
    private static String randomString(String baseString, int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        if (length < 1) {
            length = 1;
        }
        int baseLength = baseString.length();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }
}
