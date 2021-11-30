package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.CrewmateDao;
import org.example.dao.api.ImposterDao;
import org.example.dao.api.LocationDao;
import org.example.dao.api.TaskDao;
import org.example.entity.*;
import org.example.service.api.CrewmateService;
import org.example.service.exception.NullEntityException;
import org.example.util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CrewmateServiceImpl extends AbstractService<Crewmate, CrewmateDao> implements CrewmateService {

    private final int SKIP_NUMBER = -1;
    private final LocationDao locationDao;
    private final ImposterDao imposterDao;
    private final TaskDao taskDao;

    @Override
    public void changeLocation(Long crewmateId, Long locationId) throws NullEntityException {
        Optional<Location> optionalLocation = locationDao.getById(locationId);
        Optional<Crewmate> optionalCrewmate = dao.getById(crewmateId);

        Crewmate crewmate = null;
        Location oldLocation = null;
        Location newLocation = null;

        if (optionalCrewmate.isPresent() && optionalLocation.isPresent()) {
            crewmate = optionalCrewmate.get();
            oldLocation = crewmate.getLocation();
            oldLocation.getCrewmates().remove(crewmate);

            newLocation = optionalLocation.get();
            crewmate.setLocation(newLocation);
            newLocation.getCrewmates().add(crewmate);


            locationDao.update(oldLocation);
            locationDao.update(newLocation);
            dao.update(crewmate);

            log.info(crewmate.getNickname()
                    + " "
                    + "перешел из локации "
                    + oldLocation.getLocationName()
                    + " "
                    + "в локацию "
                    + newLocation.getLocationName());

            if (newLocation.isDeadBody()) {
                log.info("Свучивось горе,одного из нашего грохнули,общий сбор в туалете!");
                log.info("Выбираем предателя(или нет)");

                List<Player> alivePlayers = new ArrayList<>();
                List<Crewmate> aliveCrewmate = dao.getAllNotDead();
                List<Imposter> aliveImposter = imposterDao.getAllNotDead();
                alivePlayers.addAll(aliveCrewmate);
                alivePlayers.addAll(aliveImposter);

                int choice = RandomUtil.randomInt(alivePlayers.size(), SKIP_NUMBER);
                if (choice == SKIP_NUMBER) {
                    log.info("Решили никого не выгонять,свои же");
                    return;
                }
                Player player = alivePlayers.get(choice);

                if (player instanceof Crewmate) {

                    player.setDead(true);
                    dao.update((Crewmate) player);
                }

                if (player instanceof Imposter) {

                    player.setDead(true);
                    imposterDao.update((Imposter) player);

                }

                log.info("Мы решили дружно выпнуть " + player.getNickname());
            }
        }else throw new NullEntityException();
    }

    @Override
    public void completeTask(Long crewmateId, Long locationId) throws NullEntityException {

        Optional<Location> optionalLocation = locationDao.getById(locationId);
        Optional<Crewmate> optionalCrewmate = dao.getById(crewmateId);

        Crewmate crewmate = null;
        Location crewmateLocation = null;
        Location location = null;

        if (optionalCrewmate.isPresent() && optionalLocation.isPresent()) {
            crewmate = optionalCrewmate.get();
            crewmateLocation = crewmate.getLocation();
            location = optionalLocation.get();

            if (crewmateLocation.equals(location)) {
                List<Task> locationTasks = location.getTasks();
                List<Task> crewmateTasks = taskDao.getAllNotCompleteTask();
                Task needTask = null;

                for (int i = 0; i < locationTasks.size(); i++) {
                    if (needTask != null) break;
                    for (int j = 0; j < crewmateTasks.size(); j++) {
                        if (locationTasks.get(i).equals(crewmateTasks.get(j))) {
                            needTask = locationTasks.get(i);
                            break;
                        }
                    }
                }

                if (needTask == null) {
                    log.info("В этой локации доступных заданий нет, гуляй дальше");
                }

                needTask.setComplete(true);
                taskDao.update(needTask);

            } else {
                log.info("Ты не в этой локации, вначале перейди туда, буба");
            }
        } else {
            throw new NullEntityException();
        }
    }
}
