package com.example.rea4e.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rea4e.domain.entity.Categorias;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;
import java.util.List;

@RestController//RestController vai anotar os metodos com @ResponseBody que indica o retorno em JSON
@RequestMapping("/api/recurso-educacional-aberto")
public class RecursoEducacionalAbertoController{

    @Autowired
    private RecursoEducacionalAbertoService servico;

    @GetMapping
    public List<RecursoEducacionalAberto> listar() {
        return servico.listar();
    }

    @GetMapping("/autor/{autorId}")
    public List<RecursoEducacionalAberto> listarRecursosPorAutor(@PathVariable Long autorId) {
        return servico.listarRecursosPorAutor(autorId);
    }

    @GetMapping("/categoria/{categoria}")
    public List<RecursoEducacionalAberto> listarRecursosPorCategoria(@PathVariable String categoria) {
        Categorias cat = Categorias.valueOf(categoria);
        return servico.listarRecursosPorCategoria(cat);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RecursoEducacionalAberto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servico.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RecursoEducacionalAberto> salvar(@RequestBody RecursoEducacionalAberto recurso) {
        return ResponseEntity.ok(servico.salvar(recurso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoEducacionalAberto> atualizar(@PathVariable Long id, @RequestBody RecursoEducacionalAberto recurso) {
        return ResponseEntity.ok(servico.salvar(recurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cursoId}/recursos")
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(@PathVariable Long cursoId) {
        return servico.listarRecursosPorCurso(cursoId);
    }
}