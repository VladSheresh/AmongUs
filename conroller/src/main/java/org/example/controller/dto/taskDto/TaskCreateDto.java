package org.example.controller.dto.taskDto;

import lombok.Builder;
import lombok.Data;
import org.example.controller.dto.AbstractDto;

import java.util.List;

@Builder
@Data
public class TaskCreateDto extends AbstractDto {
    private Long locationId;
    private List<Long> crewmatesId;
}
