package com.example.luciano.client.democlient.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(name="recurso", url="http://localhost:8600/recurso")
public interface RecursoServiceRemote {

    @RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Map<String, Object>> listaautorizada();
}
