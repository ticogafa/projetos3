package com.example.rea4e.domain.entity;
import java.util.List;

public enum PapelUsuario {
    ADMIN(List.of(Permissao.GERENCIAR_USUARIOS, Permissao.GERENCIAR_REAS)),
    PROFESSOR(List.of(Permissao.CRIAR_PLAYLIST, Permissao.GERENCIAR_REAS)),
    ESTUDANTE(List.of(Permissao.VISUALIZAR_REAS, Permissao.MARCAR_REA_CONCLUIDO));

    private List<Permissao> permissoes;

    PapelUsuario(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }
}