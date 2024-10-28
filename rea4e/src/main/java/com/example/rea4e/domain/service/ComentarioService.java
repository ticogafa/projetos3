package com.example.rea4e.domain.service;
import java.util.List;
import com.example.rea4e.domain.entity.Comentario;

import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
public interface ComentarioService {
Comentario salvar(Comentario comentario);
Comentario buscarPorId(Long id);
void deletar(Long id);

//TODO: listarComentariosPorRecurso(Long recursoId)
List<Comentario> listarComentariosPorRecurso(Long recursoId);

//TODO: buscarComentariosPorUsuario(Long usuarioId)

//TODO: contarComentariosPorRecurso(Long recursoId)

Integer contarComentariosPorRecurso(Long recursoId);

List<Comentario> listarComentariosPorRecurso(RecursoEducacionalAberto recurso);


}
