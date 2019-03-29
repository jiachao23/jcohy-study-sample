package com.jcohy.study;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by jiac on 2019/3/27.
 * ClassName  : com.jcohy.study
 * Description  :
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //打印当前执行时间
        jobExecutionContext.getMergedJobDataMap();
        System.out.println("Hello World");
    }
}
