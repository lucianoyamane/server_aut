package com.example.luciano.client.democlient.authentication.service.impl;

import com.example.luciano.client.democlient.authentication.service.AuthenticationService;
import com.example.luciano.client.democlient.authentication.token.ApiKeyAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Authentication getAuthentication() {
        ApiKeyAuthenticationToken apiKeyAuthenticationToken = new ApiKeyAuthenticationToken("client_apikey");
        return apiKeyAuthenticationToken;
    }
}
