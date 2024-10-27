package com.example.rea4e.domain.service;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.RespostaComentario;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class RespostaComentarioServiceImpl extends BaseService<RespostaComentario> implements RespostaComentarioService {
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui
}
