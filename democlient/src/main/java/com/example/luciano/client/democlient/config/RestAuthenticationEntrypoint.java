package com.example.luciano.client.democlient.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAuthenticationEntrypoint implements AuthenticationEntryPoint {
    private final String headerValue;

    public RestAuthenticationEntrypoint(String headerValue) {
        this.headerValue = headerValue;
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setHeader("WWW-Authenticate", this.headerValue);
        httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "Não autorizado.");
    }
}
