package org.example.service.api;

public interface CrewmateService {
    void changeLocation(Long crewmateId,Long locationId);// + проверка на труп, написать,что нашел труп
    void completeTask(Long crewmateId);//мб больше передать данных

}
