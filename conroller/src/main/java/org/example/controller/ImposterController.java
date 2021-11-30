package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.imposterDto.ImposterCreateDto;
import org.example.controller.dto.imposterDto.ImposterGetDto;
import org.example.controller.dto.imposterDto.ImposterUpdateDto;
import org.example.entity.Imposter;
import org.example.service.api.ImposterService;
import org.example.service.exception.NullEntityException;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/imposter", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ImposterController {

    private final ImposterService imposterService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createImposter(@RequestBody ImposterCreateDto dto) {
        imposterService.save(modelMapper.map(dto, Imposter.class));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateImposter(@RequestBody ImposterUpdateDto dto) {
        imposterService.update(modelMapper.map(dto, Imposter.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImposterGetDto> getImposter(@PathVariable Long id) {
        return ResponseEntity.ok(modelMapper.map(imposterService.getById(id), ImposterGetDto.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteImposter(@PathVariable Long id) {
        imposterService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ImposterGetDto>> getAll() {
        return ResponseEntity.ok(imposterService.getAll()
                .stream()
                .map(imposter -> modelMapper.map(imposter, ImposterGetDto.class))
                .toList());
    }

    @PostMapping(value = "changeLocation/{imposterId}/{locationId}")
    public ResponseEntity<Void> changeLocationImposter(@PathVariable Long imposterId, @PathVariable Long locationId) throws NullEntityException {
        imposterService.changeLocation(imposterId, locationId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "kill/{imposterId}/{crewmateId}")
    public ResponseEntity<Void> kill(@PathVariable Long imposterId,@PathVariable Long crewmateId) throws NullEntityException {
        imposterService.kill(imposterId, crewmateId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/sabotage/{imposterId}")
    public ResponseEntity<Void> sabotage(@PathVariable Long imposterId) throws NullEntityException {
        imposterService.sabotage(imposterId);
        return ResponseEntity.ok().build();
    }

}
