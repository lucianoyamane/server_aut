package com.example.luciano.client.democlient.filter;

import com.example.luciano.client.democlient.authentication.service.AuthenticationService;
import com.example.luciano.client.democlient.config.CustomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
//@Order(1)
public class TransactionFilter  {

//    implements Filter
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        Authentication authentication =
//                authenticationService.getAuthentication();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        authentication = authenticationManager.authenticate(authentication);
//        if (authentication != null) {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//    }

}