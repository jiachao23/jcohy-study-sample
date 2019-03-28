package com.jcohy.study;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by jiac on 2019/3/27.
 * ClassName  : com.jcohy.study
 * Description  :
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //创建一个JobDetail实例，将该实例与HelloJob 绑定
       JobDetail jobDetail =  JobBuilder.newJob(HelloJob.class)
               .usingJobData("message","hello")
               .withIdentity("myjob","group1").build();
       //创建Trigger实例，定义Job立即执行，并且妹两秒钟执行一次
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2).repeatForever())
                .build();
        SchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
