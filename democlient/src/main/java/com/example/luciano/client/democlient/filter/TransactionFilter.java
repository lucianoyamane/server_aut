package com.example.luciano.client.democlient.filter;

import com.example.luciano.client.democlient.authentication.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    @Autowired
    private ApiKeyService apiKeyService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication =
                apiKeyService.getAuthentication();
        authentication = authenticationManager.authenticate(authentication);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}