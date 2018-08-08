package com.jcohy.study.security.hmac;


import com.jcohy.study.security.Encrypt;
import com.jcohy.study.security.SecurityUtils;
import com.jcohy.study.security.constans.HmacEnum;
import com.jcohy.study.security.exception.EncryptException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * HMAC摘要算法<br>
 * HMAC，全称为“Hash Message Authentication Code”，中文名“散列消息鉴别码”<br>
 * 主要是利用哈希算法，以一个密钥和一个消息为输入，生成一个消息摘要作为输出。<br>
 * 一般的，消息鉴别码用于验证传输于两个共 同享有一个密钥的单位之间的消息。<br>
 * HMAC 可以与任何迭代散列函数捆绑使用。MD5 和 SHA-1 就是这种散列函数。HMAC 还可以使用一个用于计算和确认消息鉴别值的密钥。<br>
 * 注意：此对象实例化后为非线程安全！
 *
 * @author Looly
 */
public class HMac {

    private Mac mac;
    private SecretKey secretKey;

    public HMac(HmacEnum algorithm) {
        this(algorithm, null);
    }

    public HMac(HmacEnum algorithm, byte[] key) {
        init(algorithm.getValue(), key);
    }

    /**
     * 初始化
     * @param key 密钥
     * @param algorithm 算法
     * @return {@link HMac}
     */
    public HMac init(String algorithm, byte[] key) {
        try {
            mac = Mac.getInstance(algorithm);
            if (null != key) {
                this.secretKey = new SecretKeySpec(key, algorithm);
            } else {
                this.secretKey = SecurityUtils.generateKey(algorithm);
            }
            mac.init(this.secretKey);
        } catch (Exception e) {
            throw new EncryptException(e);
        }
        return this;
    }

    // ------------------------------------------------------------------------------------------- Digest

    /**
     * 生成文件摘要
     *
     * @param data    被摘要数据
     * @param charset 编码
     * @return 摘要
     */
    public byte[] digest(String data, String charset) {
        return digest(data == null ? null : data.getBytes(charset == null || charset.trim().length() == 0 ? Charset.defaultCharset() : Charset.forName(charset)));
    }

    /**
     * 生成文件摘要
     *
     * @param data 被摘要数据
     * @return 摘要
     */
    public byte[] digest(String data) {
        return digest(data, StandardCharsets.UTF_8.name());
    }

    /**
     * 生成文件摘要，并转为16进制字符串
     *
     * @param data    被摘要数据
     * @param charset 编码
     * @return 摘要
     */
    public String digestHex(String data, String charset) {
        return Encrypt.hex.encodeHexStr(digest(data, charset));
    }

    /**
     * 生成文件摘要
     *
     * @param data 被摘要数据
     * @return 摘要
     */
    public String digestHex(String data) {
        return digestHex(data, StandardCharsets.UTF_8.name());
    }

    /**
     * 生成文件摘要<br>
     * 使用默认缓存大小
     *
     * @param file 被摘要文件
     * @return 摘要bytes
     * @throws EncryptException Cause by IOException
     */
    public byte[] digest(File file) {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            return digest(in);
        } catch (IOException e) {
            throw new EncryptException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    /**
     * 生成文件摘要，并转为16进制字符串<br>
     * 使用默认缓存大小
     *
     * @param file 被摘要文件
     * @return 摘要
     */
    public String digestHex(File file) {
        return Encrypt.hex.encodeHexStr(digest(file));
    }

    /**
     * 生成摘要
     *
     * @param data 数据bytes
     * @return 摘要bytes
     */
    public byte[] digest(byte[] data) {
        byte[] result;
        try {
            result = mac.doFinal(data);
        } finally {
            mac.reset();
        }
        return result;
    }

    /**
     * 生成摘要，并转为16进制字符串<br>
     *
     * @param data 被摘要数据
     * @return 摘要
     */
    public String digestHex(byte[] data) {
        return Encrypt.hex.encodeHexStr(digest(data));
    }

    /**
     * 生成摘要，使用默认缓存大小:1024
     *
     * @param data {@link InputStream} 数据流
     * @return 摘要bytes
     */
    public byte[] digest(InputStream data) {
        return digest(data, 1024);
    }

    /**
     * 生成摘要，并转为16进制字符串<br>
     * 使用默认缓存大小:1024
     *
     * @param data 被摘要数据
     * @return 摘要
     */
    public String digestHex(InputStream data) {
        return Encrypt.hex.encodeHexStr(digest(data));
    }

    /**
     * 生成摘要
     *
     * @param data         {@link InputStream} 数据流
     * @param bufferLength 缓存长度，不足1使用 1024 做为默认值
     * @return 摘要bytes
     */
    public byte[] digest(InputStream data, int bufferLength) {
        if (bufferLength < 1) {
            bufferLength = 1024;
        }
        byte[] buffer = new byte[bufferLength];

        byte[] result = null;
        try {
            int read = data.read(buffer, 0, bufferLength);

            while (read > -1) {
                mac.update(buffer, 0, read);
                read = data.read(buffer, 0, bufferLength);
            }
            mac.doFinal();
        } catch (IOException e) {
            throw new EncryptException(e);
        } finally {
            mac.reset();
        }
        return result;
    }

    /**
     * 生成摘要，并转为16进制字符串<br>
     * 使用默认缓存大小:1024
     *
     * @param data         被摘要数据
     * @param bufferLength 缓存长度，不足1使用1024 做为默认值
     * @return 摘要
     */
    public String digestHex(InputStream data, int bufferLength) {
        return Encrypt.hex.encodeHexStr(digest(data, bufferLength));
    }

    /**
     * 获得 {@link Mac}
     *
     * @return {@link Mac}
     */
    public Mac getMac() {
        return mac;
    }
}
