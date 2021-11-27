package org.example.service.dto.imposterDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KillDto {
    private Long imposterId;
    private Long crewmateId;
}
