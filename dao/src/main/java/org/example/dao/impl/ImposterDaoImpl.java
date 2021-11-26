package org.example.dao.impl;

import org.example.dao.api.ImposterDao;
import org.example.entity.Imposter;

public class ImposterDaoImpl extends AbstractDao<Imposter> implements ImposterDao {

    @Override
    protected Class<Imposter> getEntityClass() {
        return Imposter.class;
    }
}
