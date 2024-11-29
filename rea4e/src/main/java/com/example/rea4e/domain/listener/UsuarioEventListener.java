package com.example.rea4e.domain.listener;

import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.rea4e.domain.entity.*;
import com.example.rea4e.domain.event.*;
import com.example.rea4e.domain.exception.*;
import com.example.rea4e.domain.service.*;
import com.example.rea4e.domain.repository.UsuarioRepository;

@Component
public class UsuarioEventListener {
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final RecursoEducacionalAbertoService reaService;
    private final CursoService cursoService;

    public UsuarioEventListener(UsuarioService usuarioService, UsuarioRepository usuarioRepository, RecursoEducacionalAbertoService reaService, CursoService cursoService) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.reaService = reaService;
        this.cursoService=cursoService;
    }

    @EventListener
    public void handleRecursoFavoritadoEvent(RecursoFavoritadoEvent event) {
        Long usuarioId=event.getUsuarioId();
        Long recursoId=event.getRecursoId();
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);//aqui vai verificar se o recurso existe
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe
        if (usuario.getReasFavoritos().contains(recurso)) {
            throw new ResourceAlreadyFavoritedException("Recurso já favoritado.");
        }
            usuario.getReasFavoritos().add(recurso);
            usuarioService.salvar(usuario);
        
    }

    @EventListener
    public void handleRecursoDesfavoritadoEvent(RecursoDesfavoritadoEvent event) {
        Long usuarioId=event.getUsuarioId();
        Long recursoId=event.getRecursoId();
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);//aqui vai verificar se o recurso existe
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe
        if (!usuario.getReasFavoritos().contains(recurso)) {
            throw new ResourceNotPresentInFavouritesException("Recurso não está presente na lista de favoritos.");
        }
            usuario.getReasFavoritos().add(recurso);
            usuarioRepository.save(usuario);
    }

    @EventListener
    public void handleRecursoMarcadoComoConcluido(RecursoMarcadoComoConcluidoEvent event){
        Long usuarioId=event.getUsuarioId();
        Long recursoId=event.getRecursoId();
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe
        if(usuario.getReasConcluidos().contains(recurso)){
            throw new ResourceAlreadyFinishedException("Recurso já marcado como concluído.");
        }

        usuario.getReasConcluidos().add(recurso);
        usuarioRepository.save(usuario);
    }

    @EventListener
    public void handleRecursoDesmarcadoComoConcluido(RecursoMarcadoComoConcluidoEvent event){
        Long usuarioId=event.getUsuarioId();
        Long recursoId=event.getRecursoId();
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe
        if (!usuario.getReasConcluidos().remove(recurso)) {
            throw new ResourceNotPresentInConcludedException("Recurso não encontrado nos concluídos.");
        }
        usuarioRepository.save(usuario);    
    }

@EventListener
public void handleInscricaoEmCurso(InscricaoEmCursoEvent event){
    Long usuarioId=event.getUsuarioId();
    Long cursoId=event.getCursoId();

    if(usuarioId != null && cursoId != null){

        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        Curso curso = cursoService.buscarPorId(cursoId);
        List<Curso> inscricoesUsuario = usuario.getCursosInscritos();
        boolean wasAdded = inscricoesUsuario.add(curso);
        if (!wasAdded) {
            throw new UserAlreadySubscribedException("Usuário com ID: " + usuario.getId()+" já inscrito no curso com ID: " + curso.getId());
        }
        usuarioRepository.save(usuario);
    }
}

@EventListener
public void handleDesinscricaoEmCurso(DesinscricaoEmCursoEvent event){
Long usuarioId=event.getUsuarioId();
Long cursoId=event.getCursoId();

    if(usuarioId != null && cursoId != null){
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        Curso curso = cursoService.buscarPorId(cursoId);
        List<Curso> inscricoesUsuario = usuario.getCursosInscritos();
        boolean wasRemoved = inscricoesUsuario.remove(curso);
        if (!wasRemoved) {
            throw new CourseNotFoundInSubscribedListException("Curso não encontrado nos inscritos do usuário com ID: " + usuario.getId());
        }
        usuarioRepository.save(usuario);
    }
}

}