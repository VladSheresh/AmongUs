package org.example.dao.impl;

import org.example.dao.api.ImposterDao;
import org.example.entity.Imposter;
import org.springframework.stereotype.Repository;

@Repository
public class ImposterDaoImpl extends AbstractDao<Imposter> implements ImposterDao {

    @Override
    protected Class<Imposter> getEntityClass() {
        return Imposter.class;
    }
}
