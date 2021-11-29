package org.example.service.api;


import org.example.entity.BaseEntity;

import java.util.List;
import java.util.Optional;


public interface Service<T extends BaseEntity> {
    void save(T entity);
    void update(T entity);
    void delete(Long id);
    Optional <T> getById(Long id);
    List<T> getAll();

  //  List<G> getAllSortedBy(String name);
}
