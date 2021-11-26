package org.example.service.api;

public interface ImposterService {

    void kill(Long imposterId,Long crewmateId);//поменять еще значение у мирного на смэрть
    void changeLoction(Long imposterId,Long locationId);
    void sabutage(Long imposterId);



}
