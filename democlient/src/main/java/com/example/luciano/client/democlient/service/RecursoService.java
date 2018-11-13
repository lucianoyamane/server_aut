package com.example.luciano.client.democlient.service;

import com.example.luciano.client.democlient.service.remote.RecursoServiceRemote;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecursoService {

    @Autowired
    private RecursoServiceRemote recursoServiceRemote;

    public List<Map<String, Object>> listaautorizada() {
        try {
            return recursoServiceRemote.listaautorizada();
        } catch (HystrixRuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
