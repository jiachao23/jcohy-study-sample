package com.jcohy.study.web;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/9 11:20.
 * ClassName  : Response
 * Description  :
 */
public class Response extends ConcurrentHashMap<String,Object> {

    private static final String CODE = "code";

    private static final String MSG = "msg";

    private static final String DATA = "data";

    private static final int SUCCESS = 200;

    private static final int ERROR = 500;

    public Response() {
    }

    /**
     * @return 成功返回
     */
    public static Response ok() {
        return new Response().setOk();
    }

    /**
     * 返回默认成功，只带文本信息
     * @param msg 文本信息
     * @return result
     */
    public static Response ok(String msg) {
        return new Response().setOk().set("msg", msg);
    }

    /**
     * 返回默认成功，其他自定义返回数据。
     * @param key key
     * @param value value
     * @return 返回文本信息
     */
    public static Response ok(String key, Object value) {
        return ok().set(key, value);
    }

    /**
     * 返回data数据
     * @param object 数据
     * @return result
     */
    public static Response ok(Object object) {
        return ok().set(null, object);
    }

    /**
     * 失败
     * @return result
     */
    public static Response fail() {
        return new Response().setFail();
    }

    /**
     * @param msg 返回文本
     * @return result
     */
    public static Response fail(String msg) {
        return new Response().setFail().set("msg", msg);
    }

    /**
     * 返回时自定义数据
     * @param key key
     * @param value value
     * @return result
     */
    public static Response fail(String key, Object value) {
        return fail().set(key, value);
    }

    public static Response create() {
        return new Response();
    }

    /**
     * @param key key
     * @param value value
     * @return result
     */
    public static Response create(String key, Object value) {
        return new Response().set(key, value);
    }

    /**
     * @return result
     */
    public Response setOk() {
        super.put(CODE, SUCCESS);
        return this;
    }

    public Response setFail() {
        super.put(CODE, ERROR);
        return this;
    }


    /**
     * 赋值e'a'e'e'e's
     * @param key key
     * @param value value
     * @return result
     */
    public Response set(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * @param map map
     * @return result
     */
    public Response set(Map map) {
        super.putAll(map);
        return this;
    }

    public Response set(Response ret) {
        super.putAll(ret);
        return this;
    }

    /**
     * @param key key
     * @return result
     */
    public Response delete(Object key) {
        super.remove(key);
        return this;
    }

    public <T> T getAs(Object key) {
        return (T)get(key);
    }

    /**
     * @param key key
     * @return result
     */
    public String getStr(Object key) {
        return (String)get(key);
    }

    /**
     * @param key key
     * @return result
     */
    public Integer getInt(Object key) {
        return (Integer)get(key);
    }

    /**
     * @param key key
     * @return value
     */
    public Long getLong(Object key) {
        return (Long)get(key);
    }

    /**
     * @param key key
     * @return result
     */
    public Boolean getBoolean(Object key) {
        return (Boolean)get(key);
    }

    /**
     * key 存在，并且 value 不为 null
     *  @param key key
     *  @return reslut
     */
    public boolean notNull(Object key) {
        return get(key) != null;
    }

    /**
     * key 不存在，或者 key 存在但 value 为null
     *  @param key key
     *  @return reslut
     */
    public boolean isNull(Object key) {
        return get(key) == null;
    }

    /**
     * key 存在，并且 value 为 true，则返回 true
     *  @param key key
     *  @return reslut
     */
    public boolean isTrue(Object key) {
        Object value = get(key);
        return (value instanceof Boolean && ((Boolean)value == true));
    }

    /**
     * key 存在，并且 value 为 false，则返回 true
     *  @param key key
     *  @return reslut
     */
    public boolean isFalse(Object key) {
        Object value = get(key);
        return (value instanceof Boolean && ((Boolean)value == false));
    }

    @Override
    public boolean equals(Object ret) {
        return ret instanceof Response && super.equals(ret);
    }
}
