package org.example.dao.impl;

import org.example.dao.api.PlayerViewDao;
import org.example.entity.Player;
import org.example.entity.PlayerView;

public class PlayerViewDaoImpl extends AbstractDao<PlayerView> implements PlayerViewDao {

    @Override
    protected Class<PlayerView> getEntityClass() {
        return PlayerView.class;
    }
}
