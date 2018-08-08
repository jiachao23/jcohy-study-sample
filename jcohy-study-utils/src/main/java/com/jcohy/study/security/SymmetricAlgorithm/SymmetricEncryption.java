package com.jcohy.study.security.SymmetricAlgorithm;


import com.jcohy.study.security.SecurityUtils;
import com.jcohy.study.security.constans.SymmetricEnum;
import com.jcohy.study.security.exception.EncryptException;
import com.jcohy.study.security.zsupport.FastByteArrayOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEParameterSpec;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对称加密算法<br>
 *
 * @author Looly
 */
public class SymmetricEncryption {

    /**
     * SecretKey 负责保存对称密钥
     */
    private SecretKey secretKey;
    /**
     * Cipher负责完成加密或解密工作
     */
    private Cipher cipher;
    /**
     * 加密解密参数
     */
    private AlgorithmParameterSpec params;
    private Lock lock = new ReentrantLock();

    //------------------------------------------------------------------ Constructor start

    /**
     * 构造
     *
     * @param algorithm {@link SymmetricEnum}
     */
    public SymmetricEncryption(SymmetricEnum algorithm) {
        this(algorithm, null);
    }

    /**
     * 构造
     *
     * @param algorithm 算法
     */
    public SymmetricEncryption(String algorithm) {
        this(algorithm, null);
    }

    /**
     * 构造
     *
     * @param algorithm {@link SymmetricEnum}
     * @param key       自定义KEY
     */
    public SymmetricEncryption(SymmetricEnum algorithm, byte[] key) {
        this(algorithm.getValue(), key);
    }

    public SymmetricEncryption(String algorithm, byte[] key) {
        init(algorithm, key);
    }
    //------------------------------------------------------------------ Constructor end

    /**
     * 初始化
     *
     * @param algorithm 算法
     * @param key       密钥，如果为<code>null</code>自动生成一个key
     * @return {@link SymmetricEncryption}
     */
    public SymmetricEncryption init(String algorithm, byte[] key) {
        this.secretKey = SecurityUtils.generateKey(algorithm, key);
        if (algorithm.startsWith("PBE")) {
            //对于PBE算法使用随机数加盐
            Random random = new Random();
            byte[] bytes = new byte[8];
            random.nextBytes(bytes);
            this.params = new PBEParameterSpec(bytes, 100);
        }
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
        return this;
    }

    //--------------------------------------------------------------------------------- Encrypt

    /**
     * 加密
     *
     * @param data 被加密的bytes
     * @return 加密后的bytes
     */
    public byte[] encrypt(byte[] data) {
        lock.lock();
        try {
            if (null == this.params) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, params);
            }
            return cipher.doFinal(data);
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
     * @return 加密后的bytes
     */
    public byte[] encrypt(String data, String charset) {
        if (data == null) {
            return null;
        }
        return encrypt(charset == null || charset.length() == 0 ? data.getBytes() : data.getBytes(Charset.forName(charset)));
    }

    /**
     * 加密，使用UTF-8编码
     *
     * @param data 被加密的字符串
     * @return 加密后的bytes
     */
    public byte[] encrypt(String data) {
        if (data == null) {
            return null;
        }
        return encrypt(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 加密
     *
     * @param data 被加密的字符串
     * @return 加密后的bytes
     */
    public byte[] encrypt(InputStream data) {
        try {
            return encrypt(readBytes(data));
        } catch (IOException e) {
            throw new EncryptException(e);
        }
    }

    //--------------------------------------------------------------------------------- Decrypt

    /**
     * 解密
     *
     * @param bytes 被解密的bytes
     * @return 解密后的bytes
     */
    public byte[] decrypt(byte[] bytes) {
        lock.lock();
        try {
            if (null == this.params) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, secretKey, params);
            }
            return cipher.doFinal(bytes);
        } catch (Exception e) {
            throw new EncryptException(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 解密
     *
     * @param data 被解密的bytes
     * @return 解密后的bytes
     */
    public byte[] decrypt(InputStream data) {
        try {
            return decrypt(readBytes(data));
        } catch (IOException e) {
            throw new EncryptException(e);
        }
    }

    //--------------------------------------------------------------------------------- Getters

    /**
     * 获得对称密钥
     *
     * @return 获得对称密钥
     */
    public SecretKey getSecretKey() {
        return secretKey;
    }

    /**
     * 获得加密或解密器
     *
     * @return 加密或解密
     */
    public Cipher getCipher() {
        return cipher;
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
