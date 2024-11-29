package com.example.rea4e.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;
import com.example.rea4e.domain.service.CursoService;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;
import com.example.rea4e.domain.service.UsuarioService;

@RestController//RestController vai anotar os metodos com @ResponseBody que indica o retorno em JSON
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService crs;
    private final RecursoEducacionalAbertoService rea;
    public CursoController(CursoService crs, RecursoEducacionalAbertoService usr) {
        this.crs = crs;
        this.rea = usr;
    }

    @GetMapping()
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = crs.listar();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
        Curso cursoSalvo = crs.salvar(curso);
        return new ResponseEntity<>(cursoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deletar(@RequestBody Long id) {
        crs.deletar(id);//logica de verifcacao esta no service
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@RequestBody Curso curso) {
        Curso cursoAtualizado = crs.salvar(curso);
        return new ResponseEntity<>(cursoAtualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        Curso curso = crs.buscarPorId(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("/{cursoId}/{recursoId}")//ambos curso e recurso ja devem estar criados
    public ResponseEntity<Curso> adicionarRecursoAoCurso(@RequestBody Long cursoId, @RequestBody Long recursoId) {
        Curso curso = crs.adicionarRecursoAoCurso(cursoId, recursoId);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @DeleteMapping("/{cursoId}/{recursoId}")
    public ResponseEntity<Void> removerRecursoDoCurso(@RequestBody Long cursoId, @RequestBody Long recursoId) {
        crs.removerRecursoDoCurso(cursoId, recursoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{cursoId}/recursos")
    public List<RecursoEducacionalAberto> listarRecursosPorCurso(@PathVariable Long cursoId) {
        Curso curso = crs.buscarPorId(cursoId);
        return rea.listarRecursosPorCurso(curso);
    }

}