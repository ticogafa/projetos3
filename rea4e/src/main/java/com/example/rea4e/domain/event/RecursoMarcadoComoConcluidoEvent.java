package com.example.rea4e.domain.event;

import org.springframework.context.ApplicationEvent;

public class RecursoMarcadoComoConcluidoEvent extends ApplicationEvent{
private final Long recursoId;
private final Long usuarioId;
public RecursoMarcadoComoConcluidoEvent(Object source, Long recursoId, Long usuarioId){
super(source);
this.recursoId=recursoId;
this.usuarioId=usuarioId;
}

public Long getRecursoId() {
    return recursoId;
}

public Long getUsuarioId() {
    return usuarioId;
}
}