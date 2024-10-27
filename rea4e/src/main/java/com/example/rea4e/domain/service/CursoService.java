package com.example.rea4e.domain.service;

import java.util.List;

import com.example.rea4e.domain.entity.Curso;

public interface CursoService {

Curso salvar(Curso curso);

void deletar(Long id);

List<Curso> listar();

Curso buscarPorId(Long id);


//TODO: adicionarRecursoAoCurso(Long cursoId, Long recursoId)

//TODO: removerRecursoDoCurso(Long cursoId, Long recursoId)

//TODO: listarRecursosDoCurso(Long cursoId)

//TODO buscarCursoPorId(Long id)

}
