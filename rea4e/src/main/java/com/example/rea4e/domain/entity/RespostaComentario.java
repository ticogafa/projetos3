package com.example.rea4e.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RespostaComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String resposta;

    @ManyToOne // Relacionamento muitos-para-um com Usuario
    @JoinColumn(name = "usuario_id") // Nome da coluna que referencia o usuário
    private Usuario autor;

    @Column
    private int curtidas;

    // Método para curtir a resposta
    public void curtir() {
        this.curtidas++;
    }
}
