package com.example.rea4e.domain.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rea4e.domain.entity.Avaliacao;
import com.example.rea4e.domain.repository.AvaliacaoRepository;
import com.example.rea4e.domain.repository.RecursoEducacionalAbertoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AvaliacaoServiceImpl extends BaseService<Avaliacao> implements AvaliacaoService {

    // Todos os métodos estão disponíveis via herança.
    // Implementações específicas do domínio podem ser adicionadas aqui


//TODO: listarAvaliacoesPorRecurso(Long recursoId)
@Override
public List<Avaliacao> listarAvaliacoesPorRecurso(Long recursoId){
    return null;
}

//TODO: listarAvaliacoesPorUsuario(Long usuarioId)
@Override
public List<Avaliacao> listarAvaliacoesPorUsuario(Long usuarioId){
return null;
}

//TODO: calcularMediaAvaliacoes(Long recursoId)    
@Override
public double calcularMediaAvaliacoes(Long recursoId){

    return (Double) null;
}   
}