package com.example.rea4e.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;
import com.example.rea4e.domain.exception.NoResourcesFoundException;
import com.example.rea4e.domain.repository.RecursoEducacionalAbertoRepository;
import com.example.rea4e.domain.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InteracaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RecursoEducacionalAbertoRepository reaRepository;

    public void favoritarAula(Usuario usuario, RecursoEducacionalAberto recurso) {
        if (!usuario.getReasFavoritos().contains(recurso)) {
            usuario.getReasFavoritos().add(recurso);
            usuarioRepository.save(usuario);
        }
    }

    public void desfavoritarAula(Usuario usuario, RecursoEducacionalAberto recurso) {
        if (!usuario.getReasFavoritos().remove(recurso)) {
            throw new NoResourcesFoundException("Recurso não encontrado nos favoritos.");
        }
        usuarioRepository.save(usuario);
    }

    public void marcarReaComoConcluido(Usuario usuario, RecursoEducacionalAberto recurso) {
        if (!usuario.getReasConcluidos().contains(recurso)) {
            usuario.getReasConcluidos().add(recurso);
            usuarioRepository.save(usuario);
        }
    }
}
