package com.example.luciano.client.democlient.config;

import com.example.luciano.client.democlient.authentication.token.ApiKeyAuthenticationToken;
import com.example.luciano.client.democlient.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomProvider implements AuthenticationProvider {


    @Autowired
    private AutenticacaoService autenticacaoService;


    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        ApiKeyAuthenticationToken auth = null;

        Map<String, Object> usuarioAtenticado = autenticacaoService.autenticar(authentication);
        if (usuarioAtenticado != null && usuarioAtenticado.size() > 0) {
            auth = new ApiKeyAuthenticationToken(authentication.getCredentials().toString());
            Map<String, Object> details = new HashMap<>();
            details.put("access_token",usuarioAtenticado.get("access_token"));
            details.put("type_token",usuarioAtenticado.get("type_token"));
            auth.setDetails(details);
        } else {
            throw new UnauthorizedException("Nao autorizado");
        }
        return auth;
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    private class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String msg) {
            super(msg);
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(ApiKeyAuthenticationToken.class);
    }
}
