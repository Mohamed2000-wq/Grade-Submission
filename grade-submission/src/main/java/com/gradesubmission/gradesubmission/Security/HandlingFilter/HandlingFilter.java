package com.gradesubmission.gradesubmission.Security.HandlingFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gradesubmission.gradesubmission.ExceptionHandling.EntityExceptionHandling;

public class HandlingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            filterChain.doFilter(request, response);
        }catch(EntityExceptionHandling e){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("UserName is not correct");
            response.getWriter().flush();
        }catch(JWTVerificationException e){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("You have to enter username and password");
            response.getWriter().flush();
        }
        catch(RuntimeException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Wrong fields entered");
            response.getWriter().flush();
        }
        
    }
}
