package org.example.service.api;

import org.example.entity.Crewmate;
import org.example.entity.Location;
import org.example.service.exception.NullEntityException;

import java.util.List;

public interface LocationService extends Service <Location> {

    List<Crewmate> crewmatesInLocation(Long locationId)throws NullEntityException;

}
