package com.example.rea4e.domain.event;

import org.springframework.context.ApplicationEvent;

public class RecursoDesmarcadoConcluido extends ApplicationEvent {
    private final Long usuarioId;
    private final Long recursoId;

    public RecursoDesmarcadoConcluido(Object source, Long usuarioId, Long recursoId) {
        super(source);
        this.usuarioId = usuarioId;
        this.recursoId = recursoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getRecursoId() {
        return recursoId;
    }

}
