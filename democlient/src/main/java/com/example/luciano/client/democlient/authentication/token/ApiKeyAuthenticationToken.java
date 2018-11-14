package com.example.luciano.client.democlient.authentication.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ApiKeyAuthenticationToken extends AbstractAuthenticationToken {

    private String apikey;

    public ApiKeyAuthenticationToken( String apikey ) {
        super(null);
        this.apikey = apikey;
    }

    public Object getCredentials() {
        return apikey;
    }

    public Object getPrincipal() {
        return null;
    }
}
