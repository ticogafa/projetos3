package com.example.rea4e.domain.entity;

import lombok.Data;

import java.util.Set;
import java.util.HashSet;

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
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecursoEducacionalAberto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Sugestão: torne campos obrigatórios, se aplicável
    private String titulo;

    @ManyToOne(optional = false) // Sugestão: torne campos obrigatórios, se aplicável
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @Column // Considerar adicionar `nullable` ou `length` se necessário
    private String licenca;  // Ex: Creative Commons

    @Column(nullable = false) // Sugestão: URL pode ser obrigatório
    private String url;      // URL do recurso

    @Column(length = 500) // Sugestão: limite de caracteres para descrição
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categorias categoria;    
    
    @ManyToMany(mappedBy = "recursos") // Relacionamento muitos-para-muitos inverso
    private Set<Curso> cursos = new HashSet<>(); // Inicializa como um Set

    
    public RecursoEducacionalAberto(String titulo, Usuario autor, String url, String descricao, Categorias categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.url = url;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public RecursoEducacionalAberto(String titulo, String descricao, String url){
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }
}
