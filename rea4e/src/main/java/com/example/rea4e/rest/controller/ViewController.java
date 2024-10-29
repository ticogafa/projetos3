package com.example.rea4e.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home(Model model) {
        // Adiciona atributos ao modelo se necessário
        return "index"; // Retorna o nome do template (index.html)
    }

}
