package com.example.luciano.client.democlient.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@FeignClient(name="autenticacao", url="http://localhost:8600/autenticacao")
public interface AutenticacaoServiceRemote {

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> autenticar(Map<String, Object> usuario);

}
