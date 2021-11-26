package org.example.dao.impl;

import org.example.dao.api.CrewmateDao;
import org.example.entity.Crewmate;
import org.springframework.stereotype.Repository;

@Repository
public class CrewmateDaoImpl extends AbstractDao<Crewmate> implements CrewmateDao {

    @Override
    protected Class<Crewmate> getEntityClass() {
        return Crewmate.class;
    }
}
