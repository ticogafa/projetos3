package com.example.rea4e.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column
    private List<RecursoEducacionalAberto> recursos;  // Agrupa vários REAs

    @Column
    private String imagem;



    // Métodos para adicionar REAs à playlist
    public void adicionarRecurso(RecursoEducacionalAberto rea) {
        this.recursos.add(rea);
    }


    // Método para calcular o progresso com base nos REAs concluídos
    public double calcularProgresso(List<RecursoEducacionalAberto> reasConcluidos) {
        if (recursos.isEmpty()) return 0;
        long concluido = recursos.stream().filter(reasConcluidos::contains).count();
        return (double) concluido / recursos.size() * 100;  // Retorna o progresso em porcentagem
    }
}
