package org.example.controller.dto.commanDto;

import lombok.Builder;
import lombok.Data;
import org.example.entity.enums.Color;

@Builder
@Data
public class PlayerViewDto {
    private Color color;
    private Boolean hat;
}
