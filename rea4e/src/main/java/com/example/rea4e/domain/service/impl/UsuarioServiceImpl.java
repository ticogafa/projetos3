package com.example.rea4e.domain.service.impl;

import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Usuario;

import com.example.rea4e.domain.service.BaseService;
import com.example.rea4e.domain.service.UsuarioEventPublisher;
import com.example.rea4e.domain.service.UsuarioService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioServiceImpl extends BaseService<Usuario> implements UsuarioService {
    
    private final UsuarioEventPublisher eventPublisher;

    public UsuarioServiceImpl(UsuarioEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    public void favoritarRecurso(Long usuarioId, Long recursoId){
        eventPublisher.publishRecursoFavoritado(usuarioId, recursoId);
    }
    
    public void desfavoritarRecurso(Long usuarioId, Long recursoId){
        eventPublisher.publishRecursoDesfavoritado(usuarioId, recursoId);
    }

    public void inscreverEmCurso(Long usuarioId, Long cursoId){
        eventPublisher.publishInscricaoEmCurso(cursoId, usuarioId);
    }

    public void desinscreverEmCurso(Long usuarioId, Long cursoId){
        eventPublisher.publishDesinscricaoEmCurso(cursoId, usuarioId);
    }

    public void marcarRecursoComoConcluido(Long usuarioId, Long recursoId){
        eventPublisher.publishMarcarRecursoConcluido(recursoId, usuarioId);
    }

    public void desmarcarRecursoComoConcluido(Long usuarioId, Long recursoId){
        eventPublisher.publishDesmarcarRecursoConcluido(recursoId, usuarioId);
}



}

