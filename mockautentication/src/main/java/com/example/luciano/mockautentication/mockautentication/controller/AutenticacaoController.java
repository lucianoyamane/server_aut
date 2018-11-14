package com.example.luciano.mockautentication.mockautentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/autenticacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutenticacaoController {

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<Boolean> autentica(@RequestBody Map<String,Object> body) {
        Boolean autenticado = body.get("apikey").equals("my_apikeyx");
        Map<String, Object> resultado = new HashMap<>();
        if (autenticado) {
            resultado.put("autenticado", autenticado);
            try {
                String key = generate(128);
                resultado.put("access_token", key);
                resultado.put("type_token", "Bearer");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(resultado,
                HttpStatus.OK);
    }



    public static String generate(final int keyLen) throws NoSuchAlgorithmException {

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keyLen);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded).toLowerCase();
    }

}
