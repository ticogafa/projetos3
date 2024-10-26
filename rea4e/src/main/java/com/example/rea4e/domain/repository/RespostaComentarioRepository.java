package com.example.rea4e.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.RespostaComentario;

@Repository
public interface RespostaComentarioRepository extends JpaRepository<RespostaComentario, Long>{

}
