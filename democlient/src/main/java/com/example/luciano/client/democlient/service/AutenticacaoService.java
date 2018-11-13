package com.example.luciano.client.democlient.service;

import com.example.luciano.client.democlient.service.remote.AutenticacaoServiceRemote;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AutenticacaoService {

    @Autowired
    private AutenticacaoServiceRemote autenticacaoServiceRemote;

    public Map<String, Object> autenticar(Authentication authentication) {


        try {
            Map<String, Object> usuarioMap = new HashMap<>();
            usuarioMap.put("login", authentication.getPrincipal().toString());
            usuarioMap.put("senha", authentication.getCredentials().toString());
            return autenticacaoServiceRemote.autenticar(usuarioMap);
        } catch (HystrixRuntimeException e) {
            e.printStackTrace();
        }
        return null;

    }
}
