package com.example.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("miServicioComplejo")
@Primary
public class MyServiceComplex implements IService{


    @Override
    public String operation() {
        return "ejecucion de un proceso complicado";
    }

}
