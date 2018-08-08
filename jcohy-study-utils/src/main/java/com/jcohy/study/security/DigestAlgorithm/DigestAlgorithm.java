package com.jcohy.study.security.DigestAlgorithm;


import com.jcohy.study.security.Encrypt;
import com.jcohy.study.security.constans.DigestEnum;
import com.jcohy.study.security.exception.EncryptException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 11:16.
 * ClassName  : DigestAlgorithm
 * Description  :
 */
public class DigestAlgorithm {

    //默认缓存大小
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    private MessageDigest digest;

    public DigestAlgorithm(DigestEnum algorithm) {
        init(algorithm.getValue());
    }


    /**
     * 初始化
     * @param algorithm 算法
     * @return result
     */
    public DigestAlgorithm init(String algorithm) {
        try {
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
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
        if (data == null) {
            return null;
        }
        return digest(charset == null ? data.getBytes() : data.getBytes(Charset.forName(charset)));
    }

    /**
     * 生成文件摘要
     *
     * @param data 被摘要数据
     * @return 摘要
     */
    public byte[] digest(String data) {
        return digest(data, StandardCharsets.UTF_8.displayName());
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
        return digestHex(data, Charset.defaultCharset().displayName());
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
                } catch (Exception e) {
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
            result = digest.digest(data);
        } finally {
            digest.reset();
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
     * 生成摘要，使用默认缓存大小
     *
     * @param data {@link InputStream} 数据流
     * @return 摘要bytes
     */
    public byte[] digest(InputStream data) {
        return digest(data, DEFAULT_BUFFER_SIZE);
    }

    /**
     * 生成摘要，并转为16进制字符串<br>
     * 使用默认缓存大小
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
     * @param bufferLength 缓存长度，不足1使用  做为默认值
     * @return 摘要bytes
     */
    public byte[] digest(InputStream data, int bufferLength) {
        if (bufferLength < 1) {
            bufferLength = DEFAULT_BUFFER_SIZE;
        }
        byte[] buffer = new byte[bufferLength];

        byte[] result = null;
        try {
            int read = data.read(buffer, 0, bufferLength);

            while (read > -1) {
                digest.update(buffer, 0, read);
                read = data.read(buffer, 0, bufferLength);
            }
            digest.digest();
        } catch (IOException e) {
            throw new EncryptException(e);
        } finally {
            digest.reset();
        }
        return result;
    }

    /**
     * 生成摘要，并转为16进制字符串<br>
     * 使用默认缓存大小
     *
     * @param data         被摘要数据
     * @param bufferLength 缓存长度，
     * @return 摘要
     */
    public String digestHex(InputStream data, int bufferLength) {
        return Encrypt.hex.encodeHexStr(digest(data, bufferLength));
    }

    /**
     * 获得 {@link MessageDigest}
     *
     * @return {@link MessageDigest}
     */
    public MessageDigest getDigest() {
        return digest;
    }

}
