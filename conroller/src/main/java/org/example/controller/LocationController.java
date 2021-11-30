package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.controller.dto.locationDto.LocationCreateDto;
import org.example.controller.dto.locationDto.LocationGetDto;
import org.example.controller.dto.locationDto.LocationUpdateDto;
import org.example.entity.Location;
import org.example.service.api.LocationService;
import org.example.service.exception.NullEntityException;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/location", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createLocation(@RequestBody LocationCreateDto dto) {
        locationService.save(modelMapper.map(dto, Location.class));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateLocation(@RequestBody LocationUpdateDto dto) {
        locationService.update(modelMapper.map(dto, Location.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocationGetDto> getLocation(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(locationService.getById(id), LocationGetDto.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LocationGetDto>> getAll() {
        return ResponseEntity.ok(locationService.getAll()
                .stream()
                .map(location -> modelMapper.map(location, LocationGetDto.class))
                .toList());
    }

    @GetMapping(value = "/crewmatesInLocation/{locationId}")
    public ResponseEntity<Void> crewmatesInLocation(@PathVariable Long locationId) throws NullEntityException {
        locationService.crewmatesInLocation(locationId);
        return ResponseEntity.ok().build();
    }

}
