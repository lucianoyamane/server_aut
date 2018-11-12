package com.example.luciano.customprefilter.customprefilter.controller;

import com.example.luciano.customprefilter.customprefilter.authentication.service.AuthenticationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/res", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResourceController {



    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value="/find", method = RequestMethod.GET)
    public ResponseEntity<String> find(){
        Authentication authentication =
                authenticationService.getAuthentication();
        authentication = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok().body(new Gson().toJson("SUCESSO!!!"));
    }

}
