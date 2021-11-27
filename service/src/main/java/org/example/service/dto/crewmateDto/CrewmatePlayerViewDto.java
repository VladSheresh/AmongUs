package org.example.service.dto.crewmateDto;

import lombok.Builder;
import lombok.Data;
import org.example.entity.enums.Color;

@Builder
@Data
public class CrewmatePlayerViewDto {
    private Color color;
    private Boolean hat;
}
