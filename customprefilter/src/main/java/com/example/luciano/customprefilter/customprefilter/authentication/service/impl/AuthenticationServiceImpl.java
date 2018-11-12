package com.example.luciano.customprefilter.customprefilter.authentication.service.impl;

import com.example.luciano.customprefilter.customprefilter.authentication.service.AuthenticationService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Authentication getAuthentication() {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("admin", "admin");
        return usernamePasswordAuthenticationToken;
    }
}
