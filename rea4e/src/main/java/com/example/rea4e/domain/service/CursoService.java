package com.example.rea4e.domain.service;

import java.util.List;

import com.example.rea4e.domain.entity.Curso;

public interface CursoService {

Curso salvar(Curso curso);

void deletar(Long id);

List<Curso> listar();

Curso buscarPorId(Long id);


Curso adicionarRecursoAoCurso(Long cursoId, Long recursoId);

void removerRecursoDoCurso(Long cursoId, Long recursoId);




}
