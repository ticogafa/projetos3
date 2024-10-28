package com.example.rea4e.domain.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.exception.*;
import com.example.rea4e.domain.repository.RecursoEducacionalAbertoRepository;
import com.example.rea4e.domain.service.BaseService;
import com.example.rea4e.domain.service.CursoService;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CursoServiceImpl extends BaseService<Curso> implements CursoService {
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui
    
    private final RecursoEducacionalAbertoService recursoService;

    public CursoServiceImpl(RecursoEducacionalAbertoService recursoService, RecursoEducacionalAbertoRepository reaRepositorio) {
        this.recursoService = recursoService;
    }

    public Curso adicionarRecursoAoCurso(Long cursoId, Long recursoId) {
        Curso curso = super.buscarPorId(cursoId);
        RecursoEducacionalAberto recurso = recursoService.buscarPorId(recursoId);//aqui ja tem a verificação se o recurso existe
        boolean wasAdded = curso.getRecursos().add(recurso);
        if (!wasAdded) {
            throw new ResourceAlreadyAddedException("Recursos já adicionado ao curso com ID: " + curso.getId());
        }
        return super.salvar(curso);
    }

    public void removerRecursoDoCurso(Long cursoId, Long recursoId) {
        Curso curso = super.buscarPorId(cursoId);
        RecursoEducacionalAberto recurso = recursoService.buscarPorId(recursoId);
        boolean wasRemoved = curso.getRecursos().remove(recurso);
        if (!wasRemoved) {
            throw new NoResourcesFoundException("Recurso não encontrado no curso com ID: " + curso.getId());
        }
        super.salvar(curso);
    }



    
}
