package com.jcohy.study.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by jiac on 2019/3/14.
 * ClassName  : com.jcohy.study.redis
 * Description  :
 */
public class MonitorHelper {

    @Autowired
    private RedisTemplate redisTemplate;

    public static final Integer[] RedisConstans= new Integer[]{5,30,60,300,3600,18000};
    public void count(final String uri){
        final long now = System.currentTimeMillis();
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                for (Integer per:RedisConstans){
                    //计算应该落在那一桶中
                    long startSlice = now/per*per;
                    //时间，uri
                    String hash = String.format("%s:%s",per,uri);
                    connection.zAdd("know:".getBytes(),0,hash.getBytes());
                    connection.hIncrBy(("count:"+hash).getBytes(),String.valueOf(startSlice).getBytes(),1);
                }
                return null;
            }
        });
    }

}
