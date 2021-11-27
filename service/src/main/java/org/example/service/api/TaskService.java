package org.example.service.api;

import org.example.entity.Task;
import org.example.service.dto.taskDto.TaskCreateDto;
import org.example.service.dto.taskDto.TaskGetDto;
import org.example.service.dto.taskDto.TaskUpdateDto;

public interface TaskService extends Service<Task, TaskCreateDto,TaskUpdateDto, TaskGetDto> {

}
