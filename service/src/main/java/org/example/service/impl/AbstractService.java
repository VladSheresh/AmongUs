package org.example.service.impl;

import org.example.entity.BaseEntity;
import org.example.service.api.Service;
import org.example.service.dto.AbstractDto;

import java.util.List;

public class AbstractService<T extends BaseEntity,Z extends AbstractDto> implements Service<T, Z> {
    @Override
    public void save(Z entity) {

    }

    @Override
    public void update(Z entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Z getById(Long id) {
        return null;
    }

    @Override
    public List<Z> getAll() {
        return null;
    }

    @Override
    public List<Z> getAllSortedBy(String name) {
        return null;
    }
}
