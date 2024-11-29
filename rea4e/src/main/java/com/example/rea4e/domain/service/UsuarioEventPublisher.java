package com.example.rea4e.domain.service;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.event.*;

@Service
public class UsuarioEventPublisher {
    private final ApplicationEventPublisher publisher;

    public UsuarioEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishRecursoFavoritado(Long usuarioId, Long recursoId) {
        RecursoFavoritadoEvent event = new RecursoFavoritadoEvent(this, usuarioId, recursoId);
        publisher.publishEvent(event);
    }

    public void publishRecursoDesfavoritado(Long usuarioId, Long recursoId) {
    RecursoDesfavoritadoEvent event = new RecursoDesfavoritadoEvent(this, usuarioId, recursoId);
    publisher.publishEvent(event);
    }

    public void publishMarcarRecursoConcluido(Long recursoId, Long usuarioId){
        RecursoMarcadoComoConcluidoEvent event = new RecursoMarcadoComoConcluidoEvent(this, usuarioId, recursoId);
        publisher.publishEvent(event);
    }
    public void publishDesmarcarRecursoConcluido(Long recursoId, Long usuarioId){
        RecursoDesmarcadoComoConcluidoEvent event = new RecursoDesmarcadoComoConcluidoEvent(this, usuarioId, recursoId);
        publisher.publishEvent(event);
    }

    public void publishInscricaoEmCurso(Long cursoId, Long usuarioId){
        InscricaoEmCursoEvent event = new InscricaoEmCursoEvent(this, cursoId, usuarioId);
        publisher.publishEvent(event);
    }

    public void publishDesinscricaoEmCurso(Long cursoId, Long usuarioId) {
        DesinscricaoEmCursoEvent event = new DesinscricaoEmCursoEvent(this, cursoId, usuarioId);
        publisher.publishEvent(event);
    }

}
