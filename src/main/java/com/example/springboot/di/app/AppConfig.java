package com.example.springboot.di.app;

import com.example.springboot.di.app.models.service.IService;
import com.example.springboot.di.app.models.service.MyService;
import com.example.springboot.di.app.models.service.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    //registro por medio de Bean el servicio.
    @Bean("miServicioSimple")
    public IService registrarMyService(){
        return new MyService();
    }

    //aqui tambien podriamos utilizar Qualifier
    @Bean("miServicioComplejo")
    @Primary
    public IService registrarMyServiceComplex(){
        return new MyServiceComplex();
    }
}
