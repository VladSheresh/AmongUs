package org.example.controller.dto.locationDto;

import lombok.Builder;
import lombok.Data;
import org.example.controller.dto.AbstractDto;

@Builder
@Data
public class LocationGetDto extends AbstractDto {
    private Long locationId;
    private String locationName;
    private boolean isDeadBody;
}
