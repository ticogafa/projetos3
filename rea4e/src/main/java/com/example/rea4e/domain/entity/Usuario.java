package com.example.rea4e.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private PapelUsuario role;


    @JsonIgnore//diz para o parser que isso deve ser ignorado no nosso json
    @ManyToMany
    @JoinTable(
        name = "usuario_favoritos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rea_id")
    )
    private List<RecursoEducacionalAberto> reasFavoritos = new ArrayList<>(); // Inicializando
    
    
    @JsonIgnore//diz para o parser que isso deve ser ignorado no nosso json
    @ManyToMany
    @JoinTable(
        name = "usuario_concluidos",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rea_id")
    )
    private List<RecursoEducacionalAberto> reasConcluidos = new ArrayList<>(); // Inicializando
    
    
    @JsonIgnore//diz para o parser que isso deve ser ignorado no nosso json
    @ManyToMany
    @JoinTable(
        name = "usuario_inscricoes",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursosInscritos = new ArrayList<>(); // Inicializando


    public double calcularProgressoPlaylist(Curso playlist){
        return playlist.calcularProgresso(this.reasConcluidos);
    }


    public List<Permissao> obterPermissoes() {
        return this.role.getPermissoes();
    }

    public boolean temPermissao(Permissao permissao) {
        return this.obterPermissoes().contains(permissao);

    }

    public Usuario (String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
}



