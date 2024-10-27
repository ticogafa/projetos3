package com.example.rea4e.domain.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.example.rea4e.domain.entity.*;
import com.example.rea4e.domain.exception.NoResourcesFoundException;
import com.example.rea4e.domain.repository.RecursoEducacionalAbertoRepository;

@Transactional
@Service
public class RecursoEducacionalAbertoServiceImpl extends BaseService<RecursoEducacionalAberto> implements RecursoEducacionalAbertoService {
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui

    @Autowired
    private RecursoEducacionalAbertoRepository reaRepositorio;//So vou chamar o repositorio da entidade tratada

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;


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
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(Long cursoId) {
       return listarRecursosPorCurso(cursoService.buscarPorId(cursoId));
    }

    @Override
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(Curso curso) {
        List<RecursoEducacionalAberto> lista = reaRepositorio.findByCursosContaining(curso);
        if(lista.isEmpty()){
            throw new NoResourcesFoundException("Nenhum recurso encontrado para o curso com ID: " + curso.getId());
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
}
