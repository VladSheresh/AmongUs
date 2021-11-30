package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.locationDto.LocationCreateDto;
import org.example.controller.dto.locationDto.LocationGetDto;
import org.example.controller.dto.locationDto.LocationUpdateDto;
import org.example.controller.dto.taskDto.TaskCreateDto;
import org.example.controller.dto.taskDto.TaskGetDto;
import org.example.controller.dto.taskDto.TaskUpdateDto;
import org.example.entity.Location;
import org.example.entity.Task;
import org.example.service.api.LocationService;
import org.example.service.api.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/task", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskCreateDto dto) {
        taskService.save(modelMapper.map(dto, Task.class));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody TaskUpdateDto dto) {
        taskService.update(modelMapper.map(dto, Task.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskGetDto> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(taskService.getById(id), TaskGetDto.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskGetDto>> getAll() {
        return ResponseEntity.ok(taskService.getAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskGetDto.class))
                .toList());
    }
}
