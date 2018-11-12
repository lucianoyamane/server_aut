package com.example.luciano.customprefilter.customprefilter.controller;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/res", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResourceController {

    @RequestMapping(value="/find", method = RequestMethod.GET)
    public ResponseEntity<String> find(){
        return ResponseEntity.ok().body(new Gson().toJson("SUCESSO!!!"));
    }

}
