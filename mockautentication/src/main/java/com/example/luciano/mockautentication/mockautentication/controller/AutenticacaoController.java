package com.example.luciano.mockautentication.mockautentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autenticacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutenticacaoController {

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<Boolean> autentica(@RequestBody Object body) {
        Boolean autenticado = body != null;
        return new ResponseEntity(autenticado,
                HttpStatus.OK);
    }

}
