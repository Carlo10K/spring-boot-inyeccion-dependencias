package com.example.springboot.di.app;

import com.example.springboot.di.app.models.domain.ItemFactura;
import com.example.springboot.di.app.models.domain.Producto;
import com.example.springboot.di.app.models.service.IService;
import com.example.springboot.di.app.models.service.MyService;
import com.example.springboot.di.app.models.service.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

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

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta", 200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);

        return Arrays.asList(linea1,linea2);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor", 250);
        Producto producto2 = new Producto("Notebook", 500);
        Producto producto3 = new Producto("Impresora", 80);
        Producto producto4 = new Producto("Escritorio", 300);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);
        ItemFactura linea3 = new ItemFactura(producto3, 2);
        ItemFactura linea4 = new ItemFactura(producto4, 5);

        return Arrays.asList(linea1, linea2, linea3, linea4);
    }
}
