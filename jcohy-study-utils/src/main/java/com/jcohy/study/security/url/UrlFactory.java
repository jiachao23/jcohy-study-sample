package com.jcohy.study.security.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/6 12:02.
 * ClassName  : UrlFactory
 * Description  :
 */
public class UrlFactory {

    /**
     * url解码,UTF-8
     *
     * @param input 输入
     * @return result
     */
    public String urlDecode(String input) {
        return urlDecode(input, Charset.defaultCharset().displayName());
    }

    /**
     * URL解码
     *
     * @param input 输入
     * @param encoding 字符串
     * @return result
     */
    public String urlDecode(String input, String encoding) {
        try {
            return URLDecoder.decode(input, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported Encoding Exception", e);
        }
    }

    /**
     * URL编码,UTF-8模式
     *
     * @param input 输入
     * @return result
     */
    public String urlEncode(String input) {
        return urlEncode(input, Charset.defaultCharset().displayName());
    }

    /**
     * URL编码
     *
     * @param input 输入
     * @param encoding 字符串
     * @return result
     */
    public String urlEncode(String input, String encoding) {
        try {
            return URLEncoder.encode(input, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported Encoding Exception", e);
        }
    }
}
