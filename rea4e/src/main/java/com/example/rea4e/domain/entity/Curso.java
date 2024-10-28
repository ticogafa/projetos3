package com.example.rea4e.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categorias categoria;

    @ManyToMany
    @JoinTable(
        name = "curso_recursos",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "rea_id")
    )
    private Set<RecursoEducacionalAberto> recursos = new HashSet<>();  // Inicializa como um Set

    @Column
    private String imagem_url;


    // Método para calcular o progresso com base nos REAs concluídos
    public double calcularProgresso(List<RecursoEducacionalAberto> reasConcluidos) {
        if (recursos.isEmpty()) return 0;
        long concluido = recursos.stream().filter(reasConcluidos::contains).count();
        return (double) concluido / recursos.size() * 100;  // Retorna o progresso em porcentagem
    }
}
