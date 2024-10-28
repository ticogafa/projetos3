package com.example.rea4e.domain.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;
import com.example.rea4e.domain.exception.NoResourcesFoundException;
import com.example.rea4e.domain.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioServiceImpl extends BaseService<Usuario> implements UsuarioService {
    
@Autowired
private UsuarioRepository usuarioRepository;

@Autowired
private RecursoEducacionalAbertoService reaService;

@Autowired
private CursoService cursoService;
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui

    public void favoritarAula(Long usuarioId, Long Recurso){
        if(usuarioId != null && Recurso != null){

        }
    }
    public void desfavoritarAula(Long usuarioId, Long RecursoId){
        Usuario usuario = buscarPorId(usuarioId);
        
        if(usuarioId != null && RecursoId != null){
            List<RecursoEducacionalAberto> favoritos = usuario.getReasFavoritos();
            RecursoEducacionalAberto recurso = reaService.buscarPorId(RecursoId);
            boolean wasRemoved = favoritos.remove(recurso);
            if (!wasRemoved) {
                throw new NoResourcesFoundException("Recurso não encontrado nos favoritos do usuário com ID: " + usuario.getId());
            }
            usuarioRepository.save(usuario);
        }
    }
    public void marcarReaComoConcluido(Long usuarioId, Long reaId){
        if(usuarioId != null && reaId != null){
            Usuario usuario = buscarPorId(usuarioId);
            RecursoEducacionalAberto rea = reaService.buscarPorId(reaId);
            List<RecursoEducacionalAberto> concluidos = usuario.getReasConcluidos();
            boolean wasAdded = concluidos.add(rea);
            if (!wasAdded) {
                throw new NoResourcesFoundException("Recurso já concluído pelo usuário com ID: " + usuario.getId());
            }
            usuarioRepository.save(usuario);
        }

    }

    public void desmarcarReaComoConcluido(Long usuarioId, Long reaId){
        if(usuarioId != null && reaId != null){

        }
    }

    public void inscreverEmCurso(Long usuarioId, Long cursoId){
        if(usuarioId != null && cursoId != null){

            Usuario usuario = buscarPorId(usuarioId);
            Curso curso = cursoService.buscarPorId(cursoId);
            List<Curso> inscricoes = usuario.getCursosInscritos();
            boolean wasAdded = inscricoes.add(curso);
            if (!wasAdded) {
                throw new NoResourcesFoundException("Curso já inscrito pelo usuário com ID: " + usuario.getId());
            }
            usuarioRepository.save(usuario);
        }

    }
    public void desinscreverEmCurso(Long usuarioId, Long cursoId){

        if(usuarioId != null && cursoId != null){
            Usuario usuario = buscarPorId(usuarioId);
            Curso curso = cursoService.buscarPorId(cursoId);
            List<Curso> inscricoes = usuario.getCursosInscritos();
            boolean wasRemoved = inscricoes.remove(curso);
            if (!wasRemoved) {
                throw new NoResourcesFoundException("Curso não encontrado nos inscritos do usuário com ID: " + usuario.getId());
            }
            usuarioRepository.save(usuario);
        }
    }
    
}
