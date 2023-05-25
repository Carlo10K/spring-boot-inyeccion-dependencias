package com.example.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioComplejo")    Para registrar en java spring que es un servicio
//@Primary          Para que se use como primario
public class MyServiceComplex implements IService{

    @Override
    public String operation() {
        return "ejecucion de un proceso complicado";
    }

}
