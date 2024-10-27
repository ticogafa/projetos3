package com.example.rea4e.domain.service;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Usuario;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioServiceImpl extends BaseService<Usuario> implements UsuarioService {

    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui
}
