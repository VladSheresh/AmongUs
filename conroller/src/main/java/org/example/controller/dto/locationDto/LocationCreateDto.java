package org.example.controller.dto.locationDto;

import lombok.Builder;
import lombok.Data;
import org.example.controller.dto.AbstractDto;

@Builder
@Data
public class LocationCreateDto extends AbstractDto {
    private String locationName;
    private boolean isDeadBody;
}
