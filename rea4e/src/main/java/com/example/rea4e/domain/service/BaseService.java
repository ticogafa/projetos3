package com.example.rea4e.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.List;

public abstract class BaseService<T> {

    @Autowired
    protected JpaRepository<T, Long> repositorio;

    public List<T> listar() {
        return repositorio.findAll();
    }

    public T buscarPorId(Long id) {
        Assert.notNull(id, "ID não pode ser nulo");
        return repositorio.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada com ID: " + id));
    }

    public T salvar(T entity) {
        Assert.notNull(entity, "Entidade não pode ser nula");
        return repositorio.save(entity);
    }

    public void deletar(Long id) {
        Assert.notNull(id, "ID não pode ser nulo");
        T entity = buscarPorId(id);
        repositorio.delete(entity);
    }

    public void deletar(T entity) {
        Assert.notNull(entity, "Entidade não pode ser nula");
        repositorio.delete(entity);
    }
}
