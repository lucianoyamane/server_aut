package com.example.luciano.client.democlient.config;

import com.example.luciano.client.democlient.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CustomProvider implements AuthenticationProvider {


    @Autowired
    private AutenticacaoService autenticacaoService;


    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = null;

        Map<String, Object> usuarioAtenticado = autenticacaoService.autenticar(authentication);
        if (usuarioAtenticado != null && usuarioAtenticado.size() > 0) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
         auth = new UsernamePasswordAuthenticationToken(usuarioAtenticado.get("login"), usuarioAtenticado.get("senha"), grantedAuths);
        }
        return auth;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
