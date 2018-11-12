package com.example.luciano.customprefilter.customprefilter.authentication.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    Authentication getAuthentication();
}
