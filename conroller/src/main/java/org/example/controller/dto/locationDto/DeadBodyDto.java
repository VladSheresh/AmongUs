package org.example.controller.dto.locationDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeadBodyDto {
    public Long locationId;
    public Boolean isDeadBody;
}
