package com.example.luciano.client.democlient.authentication.service.impl;

import com.example.luciano.client.democlient.authentication.service.ApiKeyCredentialsService;
import com.example.luciano.client.democlient.config.token.ApiKeyAuthorizationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyCredentialsServiceImpl implements ApiKeyCredentialsService {

    @Override
    public Authentication getAuthentication() {
        ApiKeyAuthorizationToken apiKeyAuthorizationToken = new ApiKeyAuthorizationToken("my_apikey");
        return apiKeyAuthorizationToken;
    }
}
