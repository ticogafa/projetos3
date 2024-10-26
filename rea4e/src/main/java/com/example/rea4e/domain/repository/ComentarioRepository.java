package com.example.rea4e.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{//Long é o tipo da chave primária da tabela

    //public List<Comentario> findByNameLike(String name);

}
