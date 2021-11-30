package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.Dao;
import org.example.entity.BaseEntity;
import org.example.service.api.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractService<T extends BaseEntity, D extends Dao<T>> implements Service<T> {

    @Autowired
    protected D dao;

    @Override
    public void save(T entity) {

        log.info("Пытаюсь выполнить метод save в сервисе, обьект=" + entity);
        dao.save(entity);
        log.info("Выполняю метод save в сервисе, обьект=" + entity);
    }

    @Override
    public void update(T entity) {
        log.info("Пытаюсь выполнить метод update в сервисе, обьект=" + entity);
        dao.update(entity);
        log.info("Выполняю метод update в сервисе, обьект=" + entity);
    }

    @Override
    public void delete(Long id) {
        log.info("Пытаюсь выполнить метод delete в сервисе, обьект c id=" + id);
        dao.delete(id);
        log.info("Выполняю метод delete в сервисе, обьект c id=" + id);
    }

    @Override
    public Optional<T> getById(Long id) {

        log.info("Пытаюсь выполнить метод getById в сервисе, обьект c id=" + id);
        return dao.getById(id);
    }

    @Override
    public List<T> getAll() {
        log.info("Пытаюсь выполнить метод getAll в сервисе");
        return dao.getAll();
    }
}
