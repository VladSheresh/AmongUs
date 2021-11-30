package org.example.controller.dto.taskDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaskLocationDto {
    private Long id;
    private String locationName;
}
