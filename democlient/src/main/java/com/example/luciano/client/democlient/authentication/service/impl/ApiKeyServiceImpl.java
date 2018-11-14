package com.example.luciano.client.democlient.authentication.service.impl;

import com.example.luciano.client.democlient.authentication.service.ApiKeyService;
import com.example.luciano.client.democlient.authentication.token.ApiKeyAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    @Override
    public Authentication getAuthentication() {
        ApiKeyAuthenticationToken usernamePasswordAuthenticationToken = new ApiKeyAuthenticationToken("client_apikey");
        return usernamePasswordAuthenticationToken;
    }
}
