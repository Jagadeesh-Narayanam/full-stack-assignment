//package com.springframework.fullstackapplication.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configuration.*;
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf().disable().securityMatcher("/admin/**").authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//        return http.build();
//    }
//
//}

//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("").password("").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("").password("").roles("USER");
//    }
//
//    // security for all API
//    @Override protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//    }

    // security based on URL

    /*
     * @Override protected void configure(HttpSecurity http) throws Exception {
     * http.csrf().disable();
     * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and
     * ().httpBasic(); }
     */

    // security based on ROLE
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()..hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and()
//                .httpBasic();
//    }

//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//}
