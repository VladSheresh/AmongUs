package org.example.service.dto.commanDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangeLocationDto {
    private Long crewmateId;
    private Long locationId;
}
