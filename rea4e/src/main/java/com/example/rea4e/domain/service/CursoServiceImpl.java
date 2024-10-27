package com.example.rea4e.domain.service;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Curso;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CursoServiceImpl extends BaseService<Curso> implements CursoService {
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui
}
