package com.example.rea4e.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.*;


/**
 * Repository interface for managing RecursoEducacionalAberto entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 * 
 * Custom Query Methods:
 * - {@link #findByAutor(Usuario)}: Retrieves a list of resources created by the specified author.
 * - {@link #findByCursosContaining(Curso)}: Retrieves a list of resources associated with the specified course.
 * - {@link #findByCategoria(Categorias)}: Retrieves a list of resources belonging to the specified category.
 */
@Repository
public interface RecursoEducacionalAbertoRepository extends JpaRepository<RecursoEducacionalAberto, Long>{

    
List<RecursoEducacionalAberto> findByAutor(Usuario autor);//Por meio da assinatura do método, o Spring Data JPA entende que a consulta deve ser feita com base no atributo autor da entidade RecursoEducacionalAberto.
    
    // Método para encontrar recursos associados a um curso
List<RecursoEducacionalAberto> findByCursosContaining(Curso curso);
List<RecursoEducacionalAberto> findByCursos_Id(Long cursoId);


List<RecursoEducacionalAberto> findByCategoria(Categorias categoria);//Por meio da assinatura do método, o Spring Data JPA entende que a consulta deve ser feita com base no atributo categoria da entidade RecursoEducacionalAberto.
}
