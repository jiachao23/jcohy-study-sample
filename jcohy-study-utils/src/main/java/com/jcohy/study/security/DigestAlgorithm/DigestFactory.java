package com.jcohy.study.security.DigestAlgorithm;


import com.jcohy.study.security.constans.DigestEnum;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


/**
 * 摘要算法工具类
 *
 * @author Looly
 * @since 1.0
 */
public class DigestFactory {

    // ------------------------------------------------------------------------------------------- MD5

    /**
     * 计算16位MD5摘要值
     *
     * @param data 被摘要数据
     * @return MD5摘要
     */
    public byte[] md5(byte[] data) {
        return new DigestAlgorithm(DigestEnum.MD5).digest(data);
    }

    /**
     * 计算16位MD5摘要值
     *
     * @param data    被摘要数据
     * @param charset 编码
     * @return MD5摘要
     */
    public byte[] md5(String data, String charset) {
        return new DigestAlgorithm(DigestEnum.MD5).digest(data, charset);
    }

    /**
     * 计算16位MD5摘要值，使用UTF-8编码
     *
     * @param data 被摘要数据
     * @return MD5摘要
     */
    public byte[] md5(String data) {
        return md5(data, StandardCharsets.UTF_8.name());
    }

    /**
     * 计算16位MD5摘要值
     *
     * @param data 被摘要数据
     * @return MD5摘要
     */
    public byte[] md5(InputStream data) {
        return new DigestAlgorithm(DigestEnum.MD5).digest(data);
    }

    /**
     * 计算16位MD5摘要值
     *
     * @param file 被摘要文件
     * @return MD5摘要
     */
    public byte[] md5(File file) {
        return new DigestAlgorithm(DigestEnum.MD5).digest(file);
    }

    /**
     * 计算16位MD5摘要值，并转为16进制字符串
     *
     * @param data 被摘要数据
     * @return MD5摘要的16进制表示
     */
    public String md5Hex(byte[] data) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(data);
    }

    /**
     * 计算16位MD5摘要值，并转为16进制字符串
     *
     * @param data    被摘要数据
     * @param charset 编码
     * @return MD5摘要的16进制表示
     */
    public String md5Hex(String data, String charset) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(data, charset);
    }

    /**
     * 计算16位MD5摘要值，并转为16进制字符串
     *
     * @param data 被摘要数据
     * @return MD5摘要的16进制表示
     */
    public String md5Hex(String data) {
        return md5Hex(data, StandardCharsets.UTF_8.name());
    }

    /**
     * 计算16位MD5摘要值，并转为16进制字符串
     *
     * @param data 被摘要数据
     * @return MD5摘要的16进制表示
     */
    public String md5Hex(InputStream data) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(data);
    }

    /**
     * 计算16位MD5摘要值，并转为16进制字符串
     *
     * @param file 被摘要文件
     * @return MD5摘要的16进制表示
     */
    public String md5Hex(File file) {
        return new DigestAlgorithm(DigestEnum.MD5).digestHex(file);
    }

    // ------------------------------------------------------------------------------------------- SHA-1

    /**
     * 计算SHA-1摘要值
     *
     * @param data 被摘要数据
     * @return SHA-1摘要
     */
    public byte[] sha1(byte[] data) {
        return new DigestAlgorithm(DigestEnum.SHA1).digest(data);
    }

    /**
     * 计算SHA-1摘要值
     *
     * @param data    被摘要数据
     * @param charset 编码
     * @return SHA-1摘要
     */
    public byte[] sha1(String data, String charset) {
        return new DigestAlgorithm(DigestEnum.SHA1).digest(data, charset);
    }

    /**
     * 计算sha1摘要值，使用UTF-8编码
     *
     * @param data 被摘要数据
     * @return MD5摘要
     */
    public byte[] sha1(String data) {
        return sha1(data, StandardCharsets.UTF_8.name());
    }

    /**
     * 计算SHA-1摘要值
     *
     * @param data 被摘要数据
     * @return SHA-1摘要
     */
    public byte[] sha1(InputStream data) {
        return new DigestAlgorithm(DigestEnum.SHA1).digest(data);
    }

    /**
     * 计算SHA-1摘要值
     *
     * @param file 被摘要文件
     * @return SHA-1摘要
     */
    public byte[] sha1(File file) {
        return new DigestAlgorithm(DigestEnum.SHA1).digest(file);
    }

    /**
     * 计算SHA-1摘要值，并转为16进制字符串
     *
     * @param data 被摘要数据
     * @return SHA-1摘要的16进制表示
     */
    public String sha1Hex(byte[] data) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(data);
    }

    /**
     * 计算SHA-1摘要值，并转为16进制字符串
     *
     * @param data    被摘要数据
     * @param charset 编码
     * @return SHA-1摘要的16进制表示
     */
    public String sha1Hex(String data, String charset) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(data, charset);
    }

    /**
     * 计算SHA-1摘要值，并转为16进制字符串
     *
     * @param data 被摘要数据
     * @return SHA-1摘要的16进制表示
     */
    public String sha1Hex(String data) {
        return sha1Hex(data, StandardCharsets.UTF_8.name());
    }

    /**
     * 计算SHA-1摘要值，并转为16进制字符串
     *
     * @param data 被摘要数据
     * @return SHA-1摘要的16进制表示
     */
    public String sha1Hex(InputStream data) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(data);
    }

    /**
     * 计算SHA-1摘要值，并转为16进制字符串
     *
     * @param file 被摘要文件
     * @return SHA-1摘要的16进制表示
     */
    public String sha1Hex(File file) {
        return new DigestAlgorithm(DigestEnum.SHA1).digestHex(file);
    }
}
