package org.example.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.ImposterDao;
import org.example.entity.Imposter;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class ImposterDaoImpl extends AbstractDao<Imposter> implements ImposterDao {

    @Override
    protected Class<Imposter> getEntityClass() {
        return Imposter.class;
    }

    @Override
    public List<Imposter> getAllNotDead() {
        log.info("Выполняю метод getAllNotDead, обьект=" + Imposter.class);
        return entityManager.createQuery(
                "select i from Imposter i where i.isDead = false", Imposter.class
        ).getResultList();
    }

    @Override
    public List<Imposter> getAllDead() {
        log.info("Выполняю метод getAllDead, обьект=" + Imposter.class);
        return entityManager.createQuery(
                "select i from Imposter i where i.isDead = true", Imposter.class
        ).getResultList();
    }
}
