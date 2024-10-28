package com.example.rea4e.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.rea4e.domain.service.UsuarioService;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController//RestController vai anotar os metodos com @ResponseBody que indica o retorno em JSON
@RequestMapping("/api/usuario/")//RequestMapping vai mapear a URL
public class UsuarioController {

    @Autowired
    private UsuarioService servico;

    // Achar um usuário pelo id
    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = servico.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Criar um usuário
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        Usuario savedUsuario = servico.salvar(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    // Deletar um usuário
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Favoritar uma aula
    @PostMapping("{usuarioId}/favoritar/{recursoId}")
    public ResponseEntity<Void> favoritarAula(@PathVariable Long usuarioId, @PathVariable Long recursoId) {
        servico.favoritarRecurso(usuarioId, recursoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{usuarioId}/favoritos")
    public ResponseEntity<List<RecursoEducacionalAberto>> listarFavoritos(@PathVariable Long usuarioId) {
        Usuario usuario = servico.buscarPorId(usuarioId);
        return ResponseEntity.ok(usuario.getReasFavoritos());
    }
    
    // Desfavoritar uma aula
    @DeleteMapping("{usuarioId}/favoritar/{recursoId}")
    public ResponseEntity<Void> desfavoritarAula(@PathVariable Long usuarioId, @PathVariable Long recursoId) {
        servico.desfavoritarRecurso(usuarioId, recursoId);
        return ResponseEntity.noContent().build();
    }

    // Marcar um REA como concluído
    @PostMapping("{usuarioId}/concluir/{reaId}")
    public ResponseEntity<Void> marcarReaComoConcluido(@PathVariable Long usuarioId, @PathVariable Long reaId) {
        servico.marcarRecursoComoConcluido(usuarioId, reaId);
        return ResponseEntity.noContent().build();
    }

    // Desmarcar um REA como concluído
    @DeleteMapping("{usuarioId}/concluir/{reaId}")
    public ResponseEntity<Void> desmarcarReaComoConcluido(@PathVariable Long usuarioId, @PathVariable Long reaId) {
        servico.desmarcarRecursoComoConcluido(usuarioId, reaId);
        return ResponseEntity.noContent().build();
    }

    // Inscrever em um curso
    @PostMapping("{usuarioId}/inscrever/{cursoId}")
    public ResponseEntity<Void> inscreverEmCurso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        servico.inscreverEmCurso(usuarioId, cursoId);
        return ResponseEntity.noContent().build();
    }

    // Desinscrever de um curso
    @DeleteMapping("{usuarioId}/inscrever/{cursoId}")
    public ResponseEntity<Void> desinscreverEmCurso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        servico.desinscreverEmCurso(usuarioId, cursoId);
        return ResponseEntity.noContent().build();
    }

    
 
}
