package com.example.rea4e.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.example.rea4e.domain.entity.*;
import com.example.rea4e.domain.repository.RecursoEducacionalAbertoRepository;
import com.example.rea4e.domain.service.BaseService;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;
import com.example.rea4e.domain.service.UsuarioService;

@Transactional
@Service
public class RecursoEducacionalAbertoServiceImpl extends BaseService<RecursoEducacionalAberto> implements RecursoEducacionalAbertoService {
    private final UsuarioService usuarioService;
    private final RecursoEducacionalAbertoRepository reaRepositorio;

    public RecursoEducacionalAbertoServiceImpl(UsuarioService usuarioService, 
                                            RecursoEducacionalAbertoRepository reaRepositorio) {
        this.usuarioService = usuarioService;
        this.reaRepositorio = reaRepositorio;
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorAutor(Long autorId) {
        Usuario autor = usuarioService.buscarPorId(autorId);

        return listarRecursosPorAutor(autor);//
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorAutor(Usuario autor) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByAutor(autor);
        return lista;
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCategoria(Categorias categoria) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByCategoria(categoria);
        return lista;
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(Long cursoId) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByCursos_Id(cursoId);
        return lista;
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(Curso curso) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByCursosContaining(curso);
        return lista;
    }
}
