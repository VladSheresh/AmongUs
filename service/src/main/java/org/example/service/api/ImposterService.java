package org.example.service.api;

import org.example.entity.Imposter;
import org.example.service.dto.commanDto.ChangeLocationDto;
import org.example.service.dto.imposterDto.*;

public interface ImposterService extends Service <Imposter, ImposterCreateDto,ImposterUpdateDto, ImposterGetDto>{

    void changeLocation(ChangeLocationDto location);
    void sabotage(SabotageDto sabotage);
    void kill(KillDto kill);//поменять еще значение у мирного на смэрть

}
