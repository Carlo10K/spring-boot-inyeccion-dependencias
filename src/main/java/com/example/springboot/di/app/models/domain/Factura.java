package com.example.springboot.di.app.models.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.List;

//@RequestScope           crea y destruye el componente al hacer un request  @SessionScope para acceder a scope de sesion

@Component
@SessionScope  //acceder al contexto de sesion y nos crea una sesion http donde podemos almacenar informacion *investigar mas*
public class Factura implements Serializable {

    private static final long serialVersionUID = 946004357128146951L;

    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    //para ejecutar codigo justo despues de la creacion del objeto
    @PostConstruct
    public void init(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }

    //ejecuta antes de destruir un objeto por ejemplo darle stop al proyecto
    @PreDestroy
    public void destroy(){
        System.out.println("Factura destruidia: ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
