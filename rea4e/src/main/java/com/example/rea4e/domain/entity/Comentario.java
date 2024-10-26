package com.example.rea4e.domain.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String pergunta;

    @Column
    private Usuario autor;
    @Column
    private RecursoEducacionalAberto reaRelacionado;// Recurso Educacional Aberto relacionado à pergunta
    @Column
    private List<RespostaComentario> respostas;

    public void adicionarResposta(RespostaComentario resposta) {
        this.respostas.add(resposta);
    }






}
