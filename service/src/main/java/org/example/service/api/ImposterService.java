package org.example.service.api;

import org.example.entity.Imposter;
import org.example.service.exception.NullEntityException;

public interface ImposterService extends Service <Imposter>{

    void changeLocation(Long imposterId,Long locationId) throws NullEntityException;
    void sabotage(Long imposterId) throws NullEntityException;
    void kill(Long imposterId,Long crewmateId) throws NullEntityException;//поменять еще значение у мирного на смэрть

}
