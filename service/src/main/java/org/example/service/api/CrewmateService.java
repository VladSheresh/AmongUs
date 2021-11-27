package org.example.service.api;

import org.example.entity.Crewmate;
import org.example.service.dto.crewmateDto.CreateCrewmateDto;
import org.example.service.dto.crewmateDto.GetCrewmateDto;
import org.example.service.dto.crewmateDto.UpadateCrewmateDto;

public interface CrewmateService extends Service <Crewmate, CreateCrewmateDto, UpadateCrewmateDto, GetCrewmateDto> {
    void changeLocation(Long crewmateId,Long locationId);// + проверка на труп, написать,что нашел труп
    void completeTask(Long crewmateId);//мб больше передать данных

}
