package org.example.service.dto.locationDto;

import lombok.Builder;
import lombok.Data;
import org.example.service.dto.AbstractDto;

@Builder
@Data
public class LocationCreateDto extends AbstractDto {
    private String locationName;
    private boolean isDeadBody;
}
