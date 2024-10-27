package com.example.rea4e.domain.service;
import com.example.rea4e.domain.entity.*;
import java.util.*;

public interface AvaliacaoService {

Avaliacao salvar(Avaliacao avaliacao);
Avaliacao buscarPorId(Long id);
void deletar(Long id);

//TODO: listarAvaliacoesPorRecurso(Long recursoId)
public List<Avaliacao> listarAvaliacoesPorRecurso(Long recursoId);

//TODO: listarAvaliacoesPorUsuario(Long usuarioId)
public List<Avaliacao> listarAvaliacoesPorUsuario(Long usuarioId);

//TODO: calcularMediaAvaliacoes(Long recursoId)    
public double calcularMediaAvaliacoes(Long recursoId);  
}