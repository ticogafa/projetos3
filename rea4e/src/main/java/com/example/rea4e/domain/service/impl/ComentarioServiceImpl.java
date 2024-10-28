package com.example.rea4e.domain.service.impl;

import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Comentario;
import com.example.rea4e.domain.service.BaseService;
import com.example.rea4e.domain.service.ComentarioService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ComentarioServiceImpl extends BaseService<Comentario> implements ComentarioService{
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui
}
