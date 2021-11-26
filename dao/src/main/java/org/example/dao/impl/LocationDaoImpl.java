package org.example.dao.impl;

import org.example.dao.api.LocationDao;
import org.example.entity.Location;

public class LocationDaoImpl extends AbstractDao<Location> implements LocationDao {

    @Override
    protected Class<Location> getEntityClass() {
        return Location.class;
    }
}
