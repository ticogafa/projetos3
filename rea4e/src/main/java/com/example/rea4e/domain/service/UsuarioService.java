package com.example.rea4e.domain.service;


import com.example.rea4e.domain.entity.Usuario;


public interface UsuarioService {
Usuario salvar(Usuario usuario);
void deletar(Long id);
Usuario buscarPorId(Long id);
void favoritarAula(Long usuarioId, Long Recurso);
void desfavoritarAula(Long usuarioId, Long RecursoId);
void marcarReaComoConcluido(Long usuarioId, Long reaId);
void desmarcarReaComoConcluido(Long usuarioId, Long reaId);
void inscreverEmCurso(Long usuarioId, Long cursoId);
void desinscreverEmCurso(Long usuarioId, Long cursoId);

//void adicionarPermissaoUsuario(Long usuarioId, String permissao);
//void removerPermissaoUsuario(Long usuarioId, String permissao);
//TODO: listarPermissoesUsuario(Long usuarioId)

}
