package org.example.service.impl;

import org.example.dao.api.Dao;
import org.example.entity.BaseEntity;
import org.example.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends BaseEntity,D extends Dao<T>> implements Service<T> {

    @Autowired
    protected D dao;

    @Override
    public void save(T entity) {
        dao.save(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Optional<T> getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }
}
