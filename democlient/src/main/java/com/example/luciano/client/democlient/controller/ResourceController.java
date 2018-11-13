package com.example.luciano.client.democlient.controller;

import com.example.luciano.client.democlient.service.RecursoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/res", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResourceController {

    @Autowired
    public RecursoService recursoService;


    @RequestMapping(value="/find", method = RequestMethod.GET)
    public ResponseEntity<String> find(){
        return ResponseEntity.ok().body(new Gson().toJson("SUCESSO!!!"));
    }

    @RequestMapping(value="/recurso", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> recurso(){
        List<Map<String, Object>> resultado = recursoService.listaautorizada();
        return ResponseEntity.ok().body(resultado);
    }
}
