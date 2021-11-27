package org.example.service.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;
import org.example.entity.Location;
import org.example.service.dto.AbstractDto;

@Builder
@Data

public class CreateCrewmateDto extends AbstractDto {
    private String nickname;
//    private CrewmatePlayerViewDto crewmatePlayerViewDto;
//    private CrewmateLocationDto location;
    private Long playerViewId;
    private Long locationId;

}
