package com.example.rea4e.domain.repository;

import org.springframework.stereotype.Repository;

import com.example.rea4e.domain.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository <Usuario, Integer>{

public List<Usuario> findByNameLike(String name);

}