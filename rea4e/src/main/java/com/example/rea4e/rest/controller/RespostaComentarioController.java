package com.example.rea4e.rest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.rea4e.domain.entity.RespostaComentario;
import com.example.rea4e.domain.service.RespostaComentarioService;

@RestController
@RequestMapping("api/respostas-comentarios/")
public class RespostaComentarioController {
private final RespostaComentarioService servico;

    public RespostaComentarioController(RespostaComentarioService servico) {
        this.servico = servico;
    }



}
