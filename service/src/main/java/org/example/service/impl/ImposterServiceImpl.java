package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.CrewmateDao;
import org.example.dao.api.ImposterDao;
import org.example.dao.api.LocationDao;
import org.example.entity.Crewmate;
import org.example.entity.Imposter;
import org.example.entity.Location;
import org.example.service.api.ImposterService;
import org.example.service.exception.NullEntityException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ImposterServiceImpl extends AbstractService<Imposter, ImposterDao> implements ImposterService {

    private final CrewmateDao crewmateDao;
    private final LocationDao locationDao;

    @Override
    public void changeLocation(Long imposterId, Long locationId) throws NullEntityException {
        Optional<Location> optionalLocation = locationDao.getById(locationId);
        Optional<Imposter> optionalImposter = dao.getById(imposterId);

        Imposter imposter = null;
        Location oldLocation = null;
        Location newLocation = null;

        if (optionalImposter.isPresent() && optionalLocation.isPresent()) {
            imposter = optionalImposter.get();
            oldLocation = imposter.getLocation();
            oldLocation.getImposters().remove(imposter);

            newLocation = optionalLocation.get();
            imposter.setLocation(newLocation);
            newLocation.getImposters().add(imposter);


            locationDao.update(oldLocation);
            locationDao.update(newLocation);
            dao.update(imposter);

            log.info(imposter.getNickname()
                    + " "
                    + "перешел из локации "
                    + oldLocation.getLocationName()
                    + " "
                    + "в локацию "
                    + newLocation.getLocationName());
        }else throw new NullEntityException();
    }

    @Override
    public void sabotage(Long imposterId) throws NullEntityException {
        Optional<Imposter> optionalImposter = dao.getById(imposterId);
        Imposter imposter = null;
        if (optionalImposter.isPresent()){
            imposter = optionalImposter.get();
            log.info(imposter.getNickname() + "нагло выключил свет и нассал кому-то на ногу");
        }else throw new NullEntityException();
    }

    @Override
    public void kill(Long imposterId, Long crewmateId) throws NullEntityException {

        Optional<Imposter> optionalImposter = dao.getById(imposterId);
        Optional<Crewmate> optionalCrewmate = crewmateDao.getById(crewmateId);

        Imposter imposter = null;
        Crewmate crewmate = null;

        if (optionalCrewmate.isPresent() && optionalImposter.isPresent()) {
            crewmate = optionalCrewmate.get();
            imposter = optionalImposter.get();
            log.info("Предатель " + imposter.getNickname()+" пытается убить члена (экипажа) " + crewmate.getNickname());
            if(imposter.getLocation().equals(crewmate.getLocation()) && !crewmate.isDead() && !imposter.isDead()){
                crewmate.setDead(true);
                crewmateDao.update(crewmate);
                log.info(imposter.getNickname()+" УБИВ!!!!! " + crewmate.getNickname());
            }else{
                log.info("Локации не сходятся(а может кто-то был сдохший)");
            }
        }else throw new NullEntityException();
    }
}
