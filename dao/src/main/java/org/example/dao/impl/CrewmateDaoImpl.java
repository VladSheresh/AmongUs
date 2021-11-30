package org.example.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.CrewmateDao;
import org.example.entity.Crewmate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class CrewmateDaoImpl extends AbstractDao<Crewmate> implements CrewmateDao {

    @Override
    protected Class<Crewmate> getEntityClass() {
        return Crewmate.class;
    }

    @Override
    public List<Crewmate> getAllNotDead() {
        log.info("Выполняю метод getAllNotDead, обьект=" + Crewmate.class);
        return entityManager.createQuery(
                "select c from Crewmate c where c.isDead = false", Crewmate.class
        ).getResultList();
    }

    @Override
    public List<Crewmate> getAllDead() {
        log.info("Выполняю метод getAllDead, обьект=" + Crewmate.class);
        return entityManager.createQuery(
                "select c from Crewmate c where c.isDead = true", Crewmate.class
        ).getResultList();
    }
}
