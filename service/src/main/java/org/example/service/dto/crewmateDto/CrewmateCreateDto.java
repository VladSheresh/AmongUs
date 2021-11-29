package org.example.service.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;
import org.example.service.dto.AbstractDto;
import org.example.service.dto.commanDto.PlayerViewDto;
import org.example.service.dto.commanDto.LocationDto;

@Builder
@Data

public class CrewmateCreateDto extends AbstractDto {
    private String nickname;
    private PlayerViewDto crewmatePlayerView;
    private LocationDto location;
    private Long playerViewId;//по аналогии бейкери,берет айди,но мб и нет но работает,наверное
    private boolean isDead;
}