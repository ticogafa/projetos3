package com.example.rea4e.domain.service.impl;

import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Comentario;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.repository.ComentarioRepository;
import com.example.rea4e.domain.service.BaseService;
import com.example.rea4e.domain.service.ComentarioService;

import jakarta.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class ComentarioServiceImpl extends BaseService<Comentario> implements ComentarioService{
private final ComentarioRepository comentarioRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui
    public List<Comentario> listarComentariosPorRecurso(RecursoEducacionalAberto recurso){
        List<Comentario> lista = comentarioRepository.findByReaRelacionado(recurso);
        return lista;
    }

   public List<Comentario> listarComentariosPorRecurso(Long recursoId){
        List<Comentario> lista = comentarioRepository.findByReaRelacionado_Id(recursoId);
        return lista;
    }

    public Integer contarComentariosPorRecurso(Long recursoId){
        Integer comentarios = comentarioRepository.findByReaRelacionado_Id(recursoId).size();
        return comentarios;
    }


}