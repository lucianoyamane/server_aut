package com.example.luciano.customprefilter.customprefilter.authentication;

import com.example.luciano.customprefilter.customprefilter.service.AutenticacaoService;
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
import java.util.List;
import java.util.Map;

@Component
public class CustomProvider implements AuthenticationProvider {


    @Autowired
    private AutenticacaoService autenticacaoService;


    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String name = authentication.getPrincipal().toString();
        final String password = authentication.getCredentials().toString();

        Map<String, Object> usuarioAtenticado = autenticacaoService.autenticar(authentication);
        if (usuarioAtenticado != null && usuarioAtenticado.size() > 0) {
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));


            final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuarioAtenticado.get("login"), usuarioAtenticado.get("senha"), grantedAuths);
            return auth;
        } else {
            throw new InternalServerErrorException("Usuario invalido", new Exception());
        }
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    private class InternalServerErrorException extends RuntimeException {
        public InternalServerErrorException(String msg, Throwable t) {
            super(msg, t);
        }
    }
}



