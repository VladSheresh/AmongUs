package org.example.dao.impl;

import org.example.dao.api.PlayerViewDao;
import org.example.entity.PlayerView;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PlayerViewDaoImpl extends AbstractDao<PlayerView> implements PlayerViewDao {

    @Override
    protected Class<PlayerView> getEntityClass() {
        return PlayerView.class;
    }
}
