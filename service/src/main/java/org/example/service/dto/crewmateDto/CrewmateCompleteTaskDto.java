package org.example.service.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CrewmateCompleteTaskDto {
    private Long crewmateId;
    private Long locationId;
    private Long taskId;
}
