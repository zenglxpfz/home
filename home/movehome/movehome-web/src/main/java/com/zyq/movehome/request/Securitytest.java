package com.zyq.movehome.request;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/9/5 - 14:14
 */
@EnableWebSecurity
public class Securitytest extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/team").hasRole("team");

        //开启自动配置的登录功能,一旦定制了loginPage("/userlogin")登录页，那么发送用户名密码的登录请求处理地址为post请求的/userlogin.
        httpSecurity.formLogin().loginPage("/userlogin");
        ///login来到登录页
        //开启记住我功能
httpSecurity.rememberMe();

    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("zs").password(new BCryptPasswordEncoder().encode("123")).roles("team")
                ;
    }

}
