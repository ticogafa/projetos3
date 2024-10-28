package com.example.rea4e;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.rea4e.domain.entity.Categorias;
import com.example.rea4e.domain.entity.Curso;
import com.example.rea4e.domain.entity.RecursoEducacionalAberto;
import com.example.rea4e.domain.entity.Usuario;
import com.example.rea4e.domain.service.RecursoEducacionalAbertoService;
import com.example.rea4e.domain.service.UsuarioService;
import com.example.rea4e.domain.service.CursoService;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example.rea4e")
public class Rea4eApplication {

    public static void main(String[] args) {
        SpringApplication.run(Rea4eApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UsuarioService usuarioService, 
                             RecursoEducacionalAbertoService recursoEducacionalAbertoService, 
                             CursoService cursoService) {
        return args -> {
            System.out.println("Application started...");

            // Teste de criação de usuário
            Usuario usuario = new Usuario();
            usuario.setName("Test User");
            usuario.setEmail("test@example.com");
            usuario.setPassword("password");
            usuarioService.salvar(usuario);
            System.out.println("Usuário criado: " + usuario);

			RecursoEducacionalAberto recurso = new RecursoEducacionalAberto();
			recurso.setTitulo("Recurso de Teste");
			recurso.setDescricao("Descrição do recurso de teste");
			recurso.setAutor(usuario);
			recurso.setCategoria(Categorias.BACKEND);
			recurso.setUrl("null.com");

			recursoEducacionalAbertoService.salvar(recurso);

            // Teste de criação de curso
            Curso curso = new Curso();
            curso.setTitulo("Curso de Teste");
            curso.setDescricao("Descrição do curso de teste");
            cursoService.salvar(curso);
            System.out.println("Curso criado: " + curso);


            // Teste de inscrição em um curso
            //usuarioService.inscreverEmCurso(usuario.getId(), curso.getId());
            //System.out.println("Usuário inscrito no curso: " + curso);
        };
    }
}
