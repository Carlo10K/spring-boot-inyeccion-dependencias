package com.example.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

//@Service("miServicioSimple")
public class MyService implements IService{


    @Override
    public String operation() {
        return "ejecucion de un proceso simple";
    }

}
