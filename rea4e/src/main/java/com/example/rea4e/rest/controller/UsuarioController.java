package com.example.rea4e.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rea4e.domain.service.CursoService;
import com.example.rea4e.domain.service.UsuarioService;
import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;

import java.util.List;

@RestController//RestController vai anotar os metodos com @ResponseBody que indica o retorno em JSON
@RequestMapping("/api/usuario/")//RequestMapping vai mapear a URL
public class UsuarioController {

    @Autowired
    private UsuarioService usr;

    @Autowired
    private CursoService crs;

    // Achar um usuário pelo id
    @GetMapping("{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usr.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Criar um usuário
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usr.salvar(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    // Deletar um usuário
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usr.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Favoritar uma aula
    @PostMapping("{usuarioId}/favoritar/{recursoId}")
    public ResponseEntity<Void> favoritarAula(@PathVariable Long usuarioId, @PathVariable Long recursoId) {
        usr.favoritarRecurso(usuarioId, recursoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{usuarioId}/favoritos")
    public ResponseEntity<List<RecursoEducacionalAberto>> listarFavoritos(@PathVariable Long usuarioId) {
        Usuario usuario = usr.buscarPorId(usuarioId);
        return ResponseEntity.ok(usuario.getReasFavoritos());
    }
    
    // Desfavoritar uma aula
    @DeleteMapping("{usuarioId}/favoritar/{recursoId}")
    public ResponseEntity<Void> desfavoritarAula(@PathVariable Long usuarioId, @PathVariable Long recursoId) {
        usr.desfavoritarRecurso(usuarioId, recursoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usr.salvar(usuario));
    }

    // Marcar um REA como concluído
    @PostMapping("{usuarioId}/concluir/{reaId}")
    public ResponseEntity<Void> marcarReaComoConcluido(@PathVariable Long usuarioId, @PathVariable Long reaId) {
        usr.marcarRecursoComoConcluido(usuarioId, reaId);
        return ResponseEntity.noContent().build();
    }

    // Desmarcar um REA como concluído
    @DeleteMapping("{usuarioId}/concluir/{reaId}")
    public ResponseEntity<Void> desmarcarReaComoConcluido(@PathVariable Long usuarioId, @PathVariable Long reaId) {
        usr.desmarcarRecursoComoConcluido(usuarioId, reaId);
        return ResponseEntity.noContent().build();
    }

    // Inscrever em um curso
    @PostMapping("{usuarioId}/inscrever/{cursoId}")
    public ResponseEntity<Void> inscreverEmCurso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        usr.inscreverEmCurso(usuarioId, cursoId);
        return ResponseEntity.noContent().build();
    }

    // Desinscrever de um curso
    @DeleteMapping("{usuarioId}/inscrever/{cursoId}")
    public ResponseEntity<Void> desinscreverEmCurso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        usr.desinscreverEmCurso(usuarioId, cursoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{usuarioId}/{cursoId}/progresso")
    public ResponseEntity<Double> calcularProgresso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {

        Usuario usuario = usr.buscarPorId(usuarioId);
        Curso curso = crs.buscarPorId(cursoId);
        double progresso = usuario.calcularProgressoPlaylist(curso);
        return new ResponseEntity<>(progresso, HttpStatus.OK);
    }

    @GetMapping("{usuarioId}/cursos")
    public ResponseEntity<List<Curso>> listarCursosInscritos(@PathVariable Long usuarioId) {
        Usuario usuario = usr.buscarPorId(usuarioId);
        return ResponseEntity.ok(usuario.getCursosInscritos());
    }
}
