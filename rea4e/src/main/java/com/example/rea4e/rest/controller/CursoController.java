package com.example.rea4e.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.service.CursoService;

@RestController//RestController vai anotar os metodos com @ResponseBody que indica o retorno em JSON
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService servico;

    @GetMapping()
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = servico.listar();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
        Curso cursoSalvo = servico.salvar(curso);
        return new ResponseEntity<>(cursoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deletar(@RequestBody Long id) {
        servico.deletar(id);//logica de verifcacao esta no service
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@RequestBody Long id) {
        Curso curso = servico.buscarPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("/{cursoId}/{recursoId}")//ambos curso e recurso ja devem estar criados
    public ResponseEntity<Curso> adicionarRecursoAoCurso(@RequestBody Long cursoId, @RequestBody Long recursoId) {
        Curso curso = servico.adicionarRecursoAoCurso(cursoId, recursoId);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @DeleteMapping("/{cursoId}/{recursoId}")
    public ResponseEntity<Void> removerRecursoDoCurso(@RequestBody Long cursoId, @RequestBody Long recursoId) {
        servico.removerRecursoDoCurso(cursoId, recursoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}