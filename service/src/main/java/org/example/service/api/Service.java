package org.example.service.api;


import org.example.entity.BaseEntity;
import org.example.service.dto.AbstractDto;

import java.util.List;

public interface Service<T extends BaseEntity,C extends AbstractDto,U extends AbstractDto,G extends AbstractDto> {
    void save(C dto);
    void update(U dto);
    void delete(Long id);
    G getById(Long id);
    List<G> getAll();

  //  List<G> getAllSortedBy(String name);
}
