package com.example.rea4e.domain.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.example.rea4e.domain.entity.*;
import com.example.rea4e.domain.exception.NoResourcesFoundException;
import com.example.rea4e.domain.repository.RecursoEducacionalAbertoRepository;
import com.example.rea4e.domain.service.BaseService;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;
import com.example.rea4e.domain.service.UsuarioService;

@Transactional
@Service
public class RecursoEducacionalAbertoServiceImpl extends BaseService<RecursoEducacionalAberto> implements RecursoEducacionalAbertoService {
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui

    private final UsuarioService usuarioService;
    private final RecursoEducacionalAbertoRepository reaRepositorio;

    public RecursoEducacionalAbertoServiceImpl(UsuarioService usuarioService, RecursoEducacionalAbertoRepository reaRepositorio) {
        this.usuarioService = usuarioService;
        this.reaRepositorio = reaRepositorio;
    }
    
    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorAutor(Long autorId) {
        Usuario autor = usuarioService.buscarPorId(autorId);
        return listarRecursosPorAutor(autor);
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorAutor(Usuario autor) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByAutor(autor);
        if(lista.isEmpty()){
            throw new NoResourcesFoundException("Nenhum recurso encontrado para o autor com ID: " + autor.getId());
        }
        return lista;
    }


    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCategoria(Categorias categoria) {
        List<RecursoEducacionalAberto> lista =reaRepositorio.findByCategoria(categoria);
        if(lista.isEmpty()){
            throw new NoResourcesFoundException("Nenhum recurso encontrado para a categoria: " + categoria);
        }
        return lista;
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(Long cursoId) {
       return reaRepositorio.findByCursos_Id(cursoId);
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(Curso curso) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByCursosContaining(curso);
        if(lista.isEmpty()){
            throw new NoResourcesFoundException("Nenhum recurso encontrado para o curso com ID: " + curso.getId());
       }
        return lista;
    }
}
