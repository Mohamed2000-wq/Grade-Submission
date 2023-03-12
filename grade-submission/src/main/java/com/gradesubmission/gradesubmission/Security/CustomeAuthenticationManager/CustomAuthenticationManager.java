package com.gradesubmission.gradesubmission.Security.CustomeAuthenticationManager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gradesubmission.gradesubmission.POJO.User;
import com.gradesubmission.gradesubmission.Serivce.UserServiceImpl;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Component
public class CustomAuthenticationManager implements AuthenticationManager{
    private UserServiceImpl userServiceImpl;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       User user = userServiceImpl.getUser(authentication.getName());
        if(!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(),user.getPassword() )){
            throw new BadCredentialsException("Sorry wrong password");
        }
        return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword());
    }
}
