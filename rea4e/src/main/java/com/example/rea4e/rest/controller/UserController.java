package com.example.rea4e.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rea4e.domain.repository.UsuarioRepository;
import com.example.rea4e.domain.entity.Usuario;
import com.example.rea4e.domain.exception.UserNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/usuario/")
public class UserController {
private UsuarioRepository usuarios;

public UserController(UsuarioRepository usuarios){
    this.usuarios=usuarios;
}
//achar um usuario pelo id
@GetMapping("{id}")   
public Usuario getClienteById(@PathVariable Long id){
    return usuarios
                    .findById(id)
                    .orElseThrow( () -> new UserNotFoundException("Usuario não encontrado")//404
    );
}
//criar um usuario
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Usuario save(@RequestBody Usuario usuario){
    return usuarios.save(usuario);
}

@DeleteMapping("{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id){
    usuarios
    .findById(id)
    .map(usuario -> {
        usuarios.delete(usuario);
        return Void.TYPE;
    }).orElseThrow( () -> new UserNotFoundException("Usuário não encontrado"));
}
}