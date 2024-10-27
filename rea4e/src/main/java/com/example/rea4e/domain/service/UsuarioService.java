package com.example.rea4e.domain.service;


import com.example.rea4e.domain.entity.Usuario;

public interface UsuarioService {
Usuario salvar(Usuario usuario);
void deletar(Long id);
Usuario buscarPorId(Long id);

//TODO: listarPermissoesUsuario(Long usuarioId)

}
