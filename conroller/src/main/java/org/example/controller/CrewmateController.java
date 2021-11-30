package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.entity.Crewmate;
import org.example.service.api.CrewmateService;
import org.example.controller.dto.crewmateDto.CrewmateCreateDto;
import org.example.controller.dto.crewmateDto.CrewmateGetDto;
import org.example.controller.dto.crewmateDto.CrewmateUpdateDto;
import org.example.service.exception.NullEntityException;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/crewmate", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CrewmateController {

    private final CrewmateService crewmateService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createCrewmate(@RequestBody CrewmateCreateDto dto) {
        crewmateService.save(modelMapper.map(dto, Crewmate.class));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCrewmate(@RequestBody CrewmateUpdateDto dto) {
        crewmateService.update(modelMapper.map(dto, Crewmate.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CrewmateGetDto> getCrewmate(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(crewmateService.getById(id), CrewmateGetDto.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCrewmate(@PathVariable Long id) {
        crewmateService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CrewmateGetDto>> getAll() {
        return ResponseEntity.ok(crewmateService.getAll()
                .stream()
                .map(crewmate -> modelMapper.map(crewmate, CrewmateGetDto.class))
                .toList());
    }

    @PostMapping(value = "changeLocation/{crewmateId}/{locationId}")
    public ResponseEntity<Void> changeLocationCrewmate(@PathVariable Long crewmateId, @PathVariable Long locationId) throws NullEntityException {
        crewmateService.changeLocation(crewmateId, locationId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "completeTask/{crewmateId}/{taskId}")
    public ResponseEntity<Void> completeTaskCrewmate(@PathVariable Long crewmateId, @PathVariable Long taskId) throws NullEntityException {
        crewmateService.completeTask(crewmateId, taskId);
        return ResponseEntity.ok().build();
    }

}
