package com.plmarket.repository;

import com.plmarket.domain.BaseEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * A basic interface for {@link BaseEntity} inherited classes.
 *
 * @param <T> parametrized type.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
}
