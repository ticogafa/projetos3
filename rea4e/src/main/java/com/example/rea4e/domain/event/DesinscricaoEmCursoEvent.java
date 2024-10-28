package com.example.rea4e.domain.event;

import org.springframework.context.ApplicationEvent;

public class DesinscricaoEmCursoEvent extends ApplicationEvent{
private final Long cursoId;
private final Long usuarioId;
public DesinscricaoEmCursoEvent(Object source, Long cursoId, Long usuarioId){
    super(source);
    this.usuarioId=usuarioId;
    this.cursoId=cursoId;
}

public Long getCursoId() {
    return cursoId;
}

public Long getUsuarioId() {
    return usuarioId;
}
}
