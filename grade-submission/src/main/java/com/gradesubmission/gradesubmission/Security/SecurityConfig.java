package com.gradesubmission.gradesubmission.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.gradesubmission.gradesubmission.Security.CustomeAuthenticationManager.CustomAuthenticationManager;
import com.gradesubmission.gradesubmission.Security.Filter.AuthenticationFilter;
import com.gradesubmission.gradesubmission.Security.Filter.AuthorizationFilter;
import com.gradesubmission.gradesubmission.Security.HandlingFilter.HandlingFilter;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Configuration
public class SecurityConfig {
    CustomAuthenticationManager customAuthenticationManager;
    @Bean
    public SecurityFilterChain securityfilter(HttpSecurity http) throws Exception{
        AuthenticationFilter auth = new AuthenticationFilter(customAuthenticationManager);
        auth.setFilterProcessesUrl("/auth");
        http
        .headers().frameOptions().disable() //for h2 
        .and()   
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/h2/**").permitAll()
        .antMatchers(HttpMethod.POST,SecurityConstants.REGISTER_PATH).permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new HandlingFilter(), AuthenticationFilter.class)
        .addFilter(auth)
        .addFilterAfter(new AuthorizationFilter(), AuthenticationFilter.class)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
    
}
