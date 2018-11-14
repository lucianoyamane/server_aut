package com.example.luciano.client.democlient.config.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ApiKeyAuthorizationToken  extends AbstractAuthenticationToken {

    private String apikey;

    public ApiKeyAuthorizationToken(String apikey) {
        super(null);
        this.apikey = apikey;
    }

    @Override
    public Object getCredentials() {
        return apikey;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
