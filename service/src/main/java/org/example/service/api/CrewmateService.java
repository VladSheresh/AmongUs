package org.example.service.api;

import org.example.entity.Crewmate;
import org.example.service.exception.NullEntityException;


public interface CrewmateService extends Service <Crewmate> {
    void changeLocation(Long crewmateId,Long locationId) throws NullEntityException;// + проверка на труп, написать,что нашел труп
    void completeTask(Long crewmateId,Long locationId) throws NullEntityException;
}
