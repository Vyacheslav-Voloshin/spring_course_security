package com.voloshyn.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //дані про юзерів, їх паролі та ролі зберігаються в БД
        auth.jdbcAuthentication().dataSource(dataSource);

        //створювали юзерів та їх паролі та ролі в самій программі
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                        .withUser(userBuilder.username("camilla")
//                        .password("camilla")
//                        .roles("KIDS"))
//                        .withUser(userBuilder.username("danylo")
//                        .password("danylo")
//                        .roles("STUDENT"))
//                        .withUser(userBuilder.username("vyacheslav")
//                        .password("vyacheslav")
//                        .roles("MANAGER","STUDENT"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/").hasAnyRole("KIDS","STUDENT","MANAGER")
               .antMatchers("/student_info").hasAnyRole("STUDENT")
               .antMatchers("/manager_info").hasAnyRole("MANAGER")
               .and().formLogin().permitAll();
    }
}
