package org.example.dao.impl;

import org.example.dao.api.LocationDao;
import org.example.entity.Location;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class LocationDaoImpl extends AbstractDao<Location> implements LocationDao {

    @Override
    protected Class<Location> getEntityClass() {
        return Location.class;
    }
}
