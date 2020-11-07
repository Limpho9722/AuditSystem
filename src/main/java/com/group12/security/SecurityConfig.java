package com.group12.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  static final String User_Role = "user";
    private static final String Admin_Role = "admin";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Boss")
                .password("{noop}123")
                .roles(Admin_Role,User_Role)
                .and()
                .withUser("Client")
                .password("{noop}147")
                .roles(User_Role);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //find a particular end point for each role and who has access to them
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST,"/AuditSystem/**/create",
                        "/AuditSystem/**/delete",
                        "/AuditSystem/**/read",
                        "/AuditSystem/**/update",
                        "/AuditSystem/**/registerUserAccount",
                        "/AuditSystem/**/changePassword",
                        "/AuditSystem/**/updateEmailAddress",
                        "/AuditSystem/**/forgotPassword",
                        "/AuditSystem/**/getUserAcccountViaEmailAddress",
                        "/AuditSystem/**/all"
                ).hasRole(Admin_Role)
                .antMatchers(HttpMethod.GET,"/AuditSystem/**/read/**",
                        "/AuditSystem/**/all",
                        "/AuditSystem/**/create",
                        "/AuditSystem/**/registerAccount"
                        )
                .hasRole(User_Role)
                .and().csrf().disable();

    }
}