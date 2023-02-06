package com.springframework.fullstackapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeRequests().requestMatchers("/admin/**").authenticated().and().formLogin().and().httpBasic();
        http.authorizeRequests().requestMatchers("/user/**").permitAll();
        return http.build();
    }

}
