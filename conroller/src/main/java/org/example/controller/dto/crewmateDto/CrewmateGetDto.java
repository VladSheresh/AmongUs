package org.example.controller.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;
import org.example.controller.dto.AbstractDto;
import org.example.controller.dto.commanDto.PlayerViewDto;
import org.example.controller.dto.commanDto.LocationDto;

@Builder
@Data
public class CrewmateGetDto extends AbstractDto {
    private Long id;
    private String nickname;
    private PlayerViewDto crewmatePlayerView;
    private LocationDto location;
    private boolean isDead;
}
