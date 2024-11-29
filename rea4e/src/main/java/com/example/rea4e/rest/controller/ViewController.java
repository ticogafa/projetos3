package com.example.rea4e.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/view")
public class ViewController {


    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/cadastro")
    public String cadastrarUsuario() {
        return "cadastro";
    }
    @GetMapping("/cadastrar-recurso")
    public String cadastrarRecurso() {
        return "cadastrar-recurso";
    }

    @GetMapping("/cadastrar-curso")
    public String cadastrarCurso() {
        return "cadastrar-curso";
    }
    
    @GetMapping("/aulas")
    public String aulas() {
        return "aulas";
    }

    @GetMapping("/aula-especifica")
    public String aula() {
        return "aula-especifica";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/pagina-inicial")
    public String paginaInicial() {
        return "pagina-inicial";
    }
    
    @GetMapping("/curso")
    public String curso() {
        return "curso";
    }

    @GetMapping("/forum")
    public String test() {
        return "forum";
    }
    
    @GetMapping("/liked")
        public String liked() {
            return "liked";
        }
        
}
