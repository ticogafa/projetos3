package com.example.rea4e.domain.event;

import org.springframework.context.ApplicationEvent;



public class RecursoConcluidoEvent extends ApplicationEvent{
private final Long usuarioId;
private final Long recursoId;

public RecursoConcluidoEvent(Object source, Long usuarioId, Long recursoId) {
super(source);
this.usuarioId = usuarioId;
this.recursoId = recursoId;
}

public Long getRecursoId() {
    return recursoId;
}

public Long getUsuarioId() {
    return usuarioId;
}

}