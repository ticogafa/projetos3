package com.example.rea4e.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/view")
public class ViewController {


    @GetMapping()
    public String home() {
        return "index";
    }

    @GetMapping("/cadastrar-recurso")
    public String cadastrarRecurso() {
        return "cadastrar-recurso";
    }

    @GetMapping("/cadastrar-curso")
    public String cadastrarCurso() {
        return "cadastrar-curso";
    }
    
}
