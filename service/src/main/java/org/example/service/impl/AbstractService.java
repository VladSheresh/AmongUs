package org.example.service.impl;

import org.example.dao.api.Dao;
import org.example.entity.BaseEntity;
import org.example.service.api.Service;
import org.example.service.dto.AbstractDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractService<T extends BaseEntity,C extends AbstractDto,U extends AbstractDto,G extends AbstractDto,D extends Dao<T>> implements Service<T, C, U, G> {


    private final D dao;

    @Autowired
    public AbstractService(D dao) {
        this.dao = dao;
    }

    @Override
    public void save(C dto) {
        dao.save(dto);
    }

    @Override
    public void update(U dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public G getById(Long id) {
        return null;
    }

    @Override
    public List<G> getAll() {
        return null;
    }
}
