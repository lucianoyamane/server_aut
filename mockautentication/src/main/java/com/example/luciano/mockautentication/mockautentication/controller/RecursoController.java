package com.example.luciano.mockautentication.mockautentication.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/recurso", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecursoController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, String>>> listaautorizada(@RequestHeader("Authorization") String authorization) {

        if (authorization == null) {
            throw new BadRequestException("Sem autorizacao");
        }

        List<Map<String, String>> resultado = new ArrayList<>();
        for(int i =0; i < 5; i++) {
            Map<String, String> itemMap = new HashMap<>();
            itemMap.put("id", String.valueOf(i));
            itemMap.put("descricao", "descricao_" + i);
            resultado.add(itemMap);
        }
        return new ResponseEntity(resultado,
                HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private class BadRequestException extends RuntimeException {
        public BadRequestException(String msg) {
            super(msg);
        }
    }
}
