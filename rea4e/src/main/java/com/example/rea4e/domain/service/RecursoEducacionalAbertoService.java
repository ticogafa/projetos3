package com.example.rea4e.domain.service;

import java.util.List;

import com.example.rea4e.domain.entity.*;


public interface RecursoEducacionalAbertoService {
RecursoEducacionalAberto salvar(RecursoEducacionalAberto recurso);
RecursoEducacionalAberto buscarPorId(Long id);
void deletar(Long id);

List<RecursoEducacionalAberto> listar();

List<RecursoEducacionalAberto> listarRecursosPorAutor(Usuario autor);

List<RecursoEducacionalAberto> listarRecursosPorAutor(Long autorId);

List<RecursoEducacionalAberto> listarRecursosPorCategoria(Categorias categoria);

List<RecursoEducacionalAberto> listarRecursosPorCurso(Curso cursoId);
List<RecursoEducacionalAberto> listarRecursosPorCurso(Long cursoId);


}
