package com.example.rea4e.domain.event;

import org.springframework.context.ApplicationEvent;

public class InscricaoEmCursoEvent extends ApplicationEvent{
private final Long usuarioId;
private final Long cursoId;

public InscricaoEmCursoEvent(Object source, Long usuarioId, Long cursoId) {
    super(source);
    this.usuarioId = usuarioId;
    this.cursoId = cursoId;
}

public Long getUsuarioId() {
    return usuarioId;
}

public Long getCursoId() {
    return cursoId;
}


}
