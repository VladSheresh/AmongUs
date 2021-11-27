package org.example.service.dto.taskDto;

import lombok.Builder;
import lombok.Data;
import org.example.service.dto.AbstractDto;

import java.util.List;

@Builder
@Data
public class TaskGetDto extends AbstractDto {
    private Long id;
    private Long locationId;
    private List<Long> crewmatesId;
}
