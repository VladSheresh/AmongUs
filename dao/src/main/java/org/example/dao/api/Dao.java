package org.example.dao.api;

import org.example.entity.BaseEntity;

import java.util.Comparator;
import java.util.List;

public interface Dao <T extends BaseEntity> {
    void save(T entity);
    void update(T newEntity);
    void delete(Long id);
    T getById(Long id);
    List<T> getAll();
}
