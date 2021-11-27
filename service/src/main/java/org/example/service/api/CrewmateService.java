package org.example.service.api;

import org.example.entity.Crewmate;
import org.example.service.dto.commanDto.ChangeLocationDto;
import org.example.service.dto.crewmateDto.*;


public interface CrewmateService extends Service <Crewmate, CrewmateCreateDto, CrewmateUpdateDto, CrewmateGetDto> {
    void changeLocation(ChangeLocationDto crewmateChangeLocationDto);// + проверка на труп, написать,что нашел труп
    void completeTask(CrewmateCompleteTaskDto crewmateCompleteTaskDto);//мб больше передать данных

}
