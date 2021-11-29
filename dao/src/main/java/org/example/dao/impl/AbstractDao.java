package org.example.dao.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.Dao;
import org.example.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractDao<T extends BaseEntity> implements Dao<T> {

    @PersistenceContext
    @Getter(AccessLevel.PROTECTED)
    private EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    @Override
    public void save(T entity) {
        log.info("Выполняю метод save, обьект=" + entity);
        entityManager.persist(entity);
    }

    @Override
    public void update(T newEntity) {
        log.info("Выполняю метод update, обьект=" + newEntity);
        entityManager.merge(newEntity);
    }

    @Override
    public void delete(Long id) {
        log.info("Выполняю метод delete");
        log.debug("Выполняю метод delete, id = " + id);
        String queryString = "delete from " + getEntityClass().getName() + " ent where ent.id = :id";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Optional<T> getById(Long id) {
        log.info("Выполняю метод get, id = " + id);
        T entity = entityManager.find(getEntityClass(), id);
        return Optional.of(entity);
    }

    @Override
    public List<T> getAll() {
        log.info("Выполняю метод getAll");
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> from = query.from(getEntityClass());
        return entityManager.createQuery(query).getResultList();
    }
}
