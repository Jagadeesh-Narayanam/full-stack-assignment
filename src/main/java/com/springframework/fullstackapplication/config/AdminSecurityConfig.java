package com.springframework.fullstackapplication.config;

import com.springframework.fullstackapplication.services.CustomUserDetailsService;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeRequests().requestMatchers("/public/register").permitAll();
//        http.cors().and().csrf().disable();
//        http.authorizeRequests().requestMatchers("/public/**").permitAll();
        http.cors().and().csrf().disable().authorizeRequests().requestMatchers("/admin/**").hasAnyAuthority("ADMIN").and().httpBasic();
        http.cors().and().csrf().disable().authorizeRequests().requestMatchers("/user/**").hasAnyAuthority("ADMIN","USER").and().httpBasic();
        return http.build();
    }
}
