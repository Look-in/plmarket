package com.plmarket.service;

import com.plmarket.domain.BaseEntity;
import com.plmarket.repository.BaseRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base crud service implementation.
 *
 * @author SShankunas
 */
public abstract class BaseCrudService<T extends BaseEntity, R extends BaseRepository<T>> implements CrudService<T> {

    @Autowired
    protected R repository;

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T read(UUID id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
