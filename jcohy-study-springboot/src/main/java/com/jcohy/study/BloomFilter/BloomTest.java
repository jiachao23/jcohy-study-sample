package com.jcohy.study.BloomFilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by jiac on 2019/3/12.
 * ClassName  : com.jcohy.study.BloomFilter
 * Description  :
 */
public class BloomTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    public static final int THREAD_NUM = 1000;

    List<User> allUser;

    BloomFilter<String> bf;

    @PostConstruct
    public void add(){

        long startTime  = System.currentTimeMillis();

        allUser = userService.findAllUser();

        if(allUser == null && allUser.size() == 0){
            return;
        }

        //将数据库查到的用户放到布隆过滤器中
        bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),allUser.size());
        for(User user:allUser){
            bf.put(user.getName());
        }
        long endTime  = System.currentTimeMillis();
        System.out.println("查询并加载"+allUser.size()+"条数据到布隆过滤器花费的时间为："+(endTime-startTime));
    }

    @Test
    public void test(){
        long startTime  = System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_NUM);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        for(int i = 0;i<THREAD_NUM;i++){
            executorService.execute(new MyThread(cyclicBarrier,redisTemplate,userService));
        }
        executorService.shutdown();
        //判断是否所有线程已经运行完
        while (!executorService.isTerminated()){

        }
        long endTime  = System.currentTimeMillis();
        System.out.println("并发数："+THREAD_NUM+",新建线程已经过滤总耗时："+(endTime-startTime));
    }
    class MyThread implements Runnable{

        private CyclicBarrier cyclicBarrier;
        private RedisTemplate redisTemplate;
        private UserService userService;

        public MyThread(CyclicBarrier cyclicBarrier,RedisTemplate redisTemplate,UserService userService) {
            this.cyclicBarrier = cyclicBarrier;
            this.redisTemplate = redisTemplate;
            this.userService = userService;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            String randomUser = UUID.randomUUID().toString();
            String key = "key:"+randomUser;
            Date date1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



            if(!bf.mightContain(randomUser)){
                System.out.println(sdf.format(date1)+"  布隆过滤器中不存在，非法请求");
                return;
            }


            ValueOperations valueOperations = redisTemplate.opsForValue();
            Object cacheUser = valueOperations.get(key);
            if(cacheUser != null){
                Date date2 = new Date();
                System.out.println(sdf.format(date2)+" 命中redis缓存");
                return;
            }
            //加锁，防止并发重复写缓存
            synchronized (randomUser){
                User userByName = userService.getUserByName(randomUser);
                if(userByName == null){
                    System.out.println("redis不存在，数据库也不存在，发生缓存穿透！！！！");
                    return;
                }
                Date date3 = new Date();
                System.out.println(sdf.format(date3)+" 从数据库查询并写入缓存");
                valueOperations.set("Key:",userByName);
            }

        }
    }
}
