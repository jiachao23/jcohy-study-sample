package com.jcohy.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Created by jiac on 2018/8/9.
 * ClassName  : com.jcohy.study
 * Description  :
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {

        // Spring应用启动起来
        SpringApplication.run(SpringBootStudyApplication.class,args);
    }

    @Bean
    public ViewResolver myViewReolver(){
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

    /**
     * SpringBoot默认支持两种技术来和ES交互
     * 1.Jest（默认不生效），需要导入jest的工具包（io.searchbox.client.JestClient）
     * 2.SpringData ElasticSearch
     *1)、Client ClusterNodes
     * Client ClusterNames
     */
}
