package org.example.service.api;

import org.example.entity.Imposter;
import org.example.service.dto.imposterDto.ImposterDto;

public interface ImposterService extends Service <Imposter, ImposterDto>{

    void kill(Long imposterId,Long crewmateId);//поменять еще значение у мирного на смэрть
    void changeLoction(Long imposterId,Long locationId);
    void sabutage(Long imposterId);

}
