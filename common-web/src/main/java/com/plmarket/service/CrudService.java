package com.plmarket.service;

import com.plmarket.domain.BaseEntity;
import java.util.List;
import java.util.UUID;

/**
 * Base service interface.
 *
 * @author SShankunas
 */
public interface CrudService<T extends BaseEntity> {

    List<T> findAll();

    T read(UUID id);

    T create(T entity);

    T update(T entity);

    void delete(UUID id);

}
