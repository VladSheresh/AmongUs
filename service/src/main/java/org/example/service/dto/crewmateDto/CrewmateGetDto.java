package org.example.service.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;
import org.example.service.dto.AbstractDto;
import org.example.service.dto.commanDto.PlayerViewDto;
import org.example.service.dto.commanDto.LocationDto;

@Builder
@Data
public class CrewmateGetDto extends AbstractDto {
    private Long id;
    private String nickname;
    private PlayerViewDto crewmatePlayerView;
    private LocationDto location;
    private boolean isDead;
}
