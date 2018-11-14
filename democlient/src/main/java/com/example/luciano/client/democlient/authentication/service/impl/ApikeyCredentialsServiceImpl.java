package com.example.luciano.client.democlient.authentication.service.impl;

import com.example.luciano.client.democlient.authentication.service.ApikeyCredentialsService;
import com.example.luciano.client.democlient.authentication.token.ApiKeyAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ApikeyCredentialsServiceImpl implements ApikeyCredentialsService {

    @Override
    public Authentication getAuthentication() {
        ApiKeyAuthenticationToken apiKeyAuthenticationToken = new ApiKeyAuthenticationToken("client_apikey");
        return apiKeyAuthenticationToken;
    }
}
