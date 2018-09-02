package com.jcohy.study.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jiac on 2018/9/2.
 * ClassName  : com.jcohy.study.security
 * Description  :
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("level1/**").hasRole("VIP1")
                .antMatchers("level2/**").hasRole("VIP2")
                .antMatchers("level3/**").hasRole("VIP3");
        //开启自动配置的登录功能，如果没有权限，就会来到登录页面
        http.formLogin()
            .loginPage("/userLogin");
        //开启自动配置注销，访问/logout，表示用户注销，清空session
        http.logout()
                .logoutSuccessUrl("");//注销成功返回的页面；
        http.rememberMe();//开启记住我功能，登录成功后，讲cookie发送给浏览器，以后登录会带上这个cookie。如果通过检查就可免登录。

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("zhangsan")
                .password("123456")
                .roles("VIP1","VIP2")
                .and()
                .withUser("lisi")
                .password("123456")
                .roles("VIP1","VIP3")
                .and()
                .withUser("lisi")
                .password("123456")
                .roles("VIP2","VIP3");
    }
}
