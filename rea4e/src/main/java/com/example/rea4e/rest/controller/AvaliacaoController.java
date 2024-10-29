package com.example.rea4e.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rea4e.domain.entity.Avaliacao;
import com.example.rea4e.domain.service.AvaliacaoService;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/avaliacao")
public class AvaliacaoController {
private final AvaliacaoService avaliacaoService;

public AvaliacaoController(AvaliacaoService avaliacaoService) {
    this.avaliacaoService = avaliacaoService;
}

@PostMapping("/avaliar-recurso")
public ResponseEntity<Avaliacao> avaliarRecurso(@RequestBody Avaliacao avaliacao) {
    return ResponseEntity.ok(avaliacaoService.salvar(avaliacao));
}

@GetMapping("/media-avaliacoes/{recursoId}")
public ResponseEntity<Double> calcularMediaAvaliacoes(@PathVariable Long recursoId) {
    return ResponseEntity.ok(avaliacaoService.calcularMediaAvaliacoes(recursoId));
}

@GetMapping("/listar-avaliacoes/{recursoId}")
public ResponseEntity<List<Avaliacao>> listarAvaliacoesPorRecurso(@PathVariable Long recursoId) {
    return ResponseEntity.ok(avaliacaoService.listarAvaliacoesPorRecurso(recursoId));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable Long id) {
    avaliacaoService.deletar(id);
    return ResponseEntity.noContent().build();
}

@PutMapping("/{id}")
public ResponseEntity<Avaliacao> atualizar(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
    return ResponseEntity.ok(avaliacaoService.salvar(avaliacao));
}

@GetMapping("/{id}")
public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
    return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
}

}