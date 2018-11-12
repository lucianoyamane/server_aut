package com.example.luciano.customprefilter.customprefilter.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name="autenticacao", url="http://localhost:8600")
public interface AutenticacaoServiceRemote {

    @RequestMapping(value = "/autenticacao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> autenticar(Map<String, Object> usuario);

}
