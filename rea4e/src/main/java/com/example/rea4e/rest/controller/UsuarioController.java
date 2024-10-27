package com.example.rea4e.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rea4e.domain.service.UsuarioService;
import com.example.rea4e.domain.entity.Usuario;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

    @Autowired
    private UsuarioService servico;

    // Achar um usuário pelo id
    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = servico.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Criar um usuário
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario savedUsuario = servico.salvar(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    // Deletar um usuário
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
