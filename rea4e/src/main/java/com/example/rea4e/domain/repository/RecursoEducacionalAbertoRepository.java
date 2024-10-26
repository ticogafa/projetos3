package com.example.rea4e.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.RecursoEducacionalAberto;

@Repository
public interface RecursoEducacionalAbertoRepository extends JpaRepository<RecursoEducacionalAberto, Long>{

}
