package com.example.rea4e.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
    
List<Avaliacao> findByReaAvaliado_Id(Long reaId);

}
