package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.LocationDao;
import org.example.entity.Crewmate;
import org.example.entity.Location;
import org.example.service.api.LocationService;
import org.example.service.exception.NullEntityException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class LocationServiceImpl extends AbstractService<Location, LocationDao> implements LocationService {
    @Override
    public List<Crewmate> crewmatesInLocation(Long locationId) throws NullEntityException {

        Optional<Location> optionalLocation = dao.getById(locationId);
        Location location = null;
        log.info("Пытаемся получить список членов (экипажа) в локации " + location.getLocationName());
        if (optionalLocation.isPresent()){

            location = optionalLocation.get();
            log.info("Получили список членов (экипажа) в локации  " + location.getLocationName());
            return location.getCrewmates();

        }else throw new NullEntityException();

    }
}
