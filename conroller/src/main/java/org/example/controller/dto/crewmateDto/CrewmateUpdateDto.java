package org.example.controller.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;
import org.example.controller.dto.AbstractDto;
import org.example.controller.dto.commanDto.LocationDto;
import org.example.controller.dto.commanDto.PlayerViewDto;

@Builder
@Data
public class CrewmateUpdateDto extends AbstractDto {
    private String nickname;
    private PlayerViewDto crewmatePlayerView;
    private LocationDto location;
    private boolean isDead;
}
