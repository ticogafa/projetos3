package com.example.rea4e.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int nota;

    @Column
    private String comentario;

    @ManyToOne // Indica que uma avaliação pertence a um único usuário
    @JoinColumn(name = "usuario_id", nullable = false) // Nome da coluna no banco de dados
    private Usuario autor;

    @ManyToOne // Indica que uma avaliação é sobre um único recurso educacional
    @JoinColumn(name = "rea_id", nullable = false) // Nome da coluna no banco de dados
    private RecursoEducacionalAberto reaAvaliado;
}
