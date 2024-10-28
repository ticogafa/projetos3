package com.example.rea4e.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.Comentario;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> { // Long é o tipo da chave primária da tabela

    // public List<Comentario> findByNameLike(String name);

    // Retorna todos os comentários de um recurso específico
    List<Comentario> findByReaRelacionado(RecursoEducacionalAberto recurso);

    // Alternativamente, para buscar usando o ID do recurso relacionado
    List<Comentario> findByReaRelacionado_Id(Long recursoId);

    

}
