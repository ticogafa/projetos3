package com.example.rea4e.domain.listener;

import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;
import com.example.rea4e.domain.event.DesinscricaoEmCursoEvent;
import com.example.rea4e.domain.event.InscricaoEmCursoEvent;
import com.example.rea4e.domain.event.RecursoDesfavoritadoEvent;
import com.example.rea4e.domain.event.RecursoFavoritadoEvent;
import com.example.rea4e.domain.event.RecursoMarcadoComoConcluidoEvent;
import com.example.rea4e.domain.exception.NoResourcesFoundException;
import com.example.rea4e.domain.exception.ReourceAlreadyFinishedException;
import com.example.rea4e.domain.exception.ResourceAlreadyFavoritedException;
import com.example.rea4e.domain.repository.UsuarioRepository;
import com.example.rea4e.domain.service.CursoService;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;
import com.example.rea4e.domain.service.UsuarioService;

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
            usuarioRepository.save(usuario);
        
    }

    @EventListener
    public void handleRecursoDesfavoritadoEvent(RecursoDesfavoritadoEvent event) {
        Long usuarioId=event.getUsuarioId();
        Long recursoId=event.getRecursoId();
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);//aqui vai verificar se o recurso existe
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe
        if (usuario.getReasFavoritos().contains(recurso)) {
            throw new ResourceAlreadyFavoritedException("Recurso já favoritado.");
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
            throw new ReourceAlreadyFinishedException("Recurso já marcado como concluído.");
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
            throw new NoResourcesFoundException("Recurso não encontrado nos concluídos.");
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
        List<Curso> inscricoes = usuario.getCursosInscritos();
        boolean wasAdded = inscricoes.add(curso);
        if (!wasAdded) {
            throw new NoResourcesFoundException("Curso já inscrito pelo usuário com ID: " + usuario.getId());
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
        List<Curso> inscricoes = usuario.getCursosInscritos();
        boolean wasRemoved = inscricoes.remove(curso);
        if (!wasRemoved) {
            throw new NoResourcesFoundException("Curso não encontrado nos inscritos do usuário com ID: " + usuario.getId());
        }
        usuarioRepository.save(usuario);
    }
}
}
