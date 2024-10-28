package com.example.rea4e.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}