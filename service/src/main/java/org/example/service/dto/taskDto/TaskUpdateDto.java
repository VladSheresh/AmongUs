package org.example.service.dto.taskDto;

import lombok.Builder;
import lombok.Data;
import org.example.service.dto.AbstractDto;

import java.util.List;

@Builder
@Data
public class TaskUpdateDto extends AbstractDto {
    private Long locationId;
    private List<Long> crewmatesId;
}
