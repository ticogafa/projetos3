package com.example.rea4e.domain.service.impl;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Avaliacao;
import com.example.rea4e.domain.repository.AvaliacaoRepository;
import com.example.rea4e.domain.service.AvaliacaoService;
import com.example.rea4e.domain.service.BaseService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AvaliacaoServiceImpl extends BaseService<Avaliacao> implements AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }
    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui


@Override
public List<Avaliacao> listarAvaliacoesPorRecurso(Long recursoId){
    List<Avaliacao> lista = avaliacaoRepository.findByReaAvaliado_Id(recursoId);
    return lista;
}


@Override
public double calcularMediaAvaliacoes(Long recursoId){

    List<Avaliacao> lista = avaliacaoRepository.findByReaAvaliado_Id(recursoId);
    double media = 0;
    for (Avaliacao avaliacao : lista) {
        media += avaliacao.getNota();
    }
    media = media / lista.size();
    return media;
}

}