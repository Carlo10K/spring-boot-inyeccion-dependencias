package com.example.springboot.di.app.controllers;

import com.example.springboot.di.app.models.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //inyeccion por inicializacion
    //private MyService service = new MyService();

    //inyeccion con autowired
    @Autowired
    private MyService service;

    @GetMapping({"/", "", "/index"})
    public String index(Model model){
        model.addAttribute("object", service.operation());
        return "index";
    }


}