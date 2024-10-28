package com.example.rea4e.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String pergunta;

    @ManyToOne // Um comentário é escrito por um único autor
    @JoinColumn(name = "usuario_id", nullable = false) // Nome da coluna no banco de dados
    private Usuario autor;

    @JsonIgnore
    @ManyToOne // Um comentário está relacionado a um único recurso educacional
    @JoinColumn(name = "rea_id", nullable = false) // Nome da coluna no banco de dados
    private RecursoEducacionalAberto reaRelacionado;

    @OneToMany(mappedBy = "resposta") // Uma lista de respostas para este comentário
    private List<RespostaComentario> respostas = new ArrayList<>(); // Inicializa a lista

    public Comentario(String pergunta, Usuario autor, RecursoEducacionalAberto reaRelacionado) {
        this.pergunta = pergunta;
        this.autor = autor;
        this.reaRelacionado = reaRelacionado;
    }
}
