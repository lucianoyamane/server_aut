package com.example.luciano.client.democlient.authentication.service;

import org.springframework.security.core.Authentication;

public interface ApiKeyCredentialsService {

    Authentication getAuthentication();
}
