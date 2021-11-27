package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.service.api.CrewmateService;
import org.example.service.dto.commanDto.ChangeLocationDto;
import org.example.service.dto.crewmateDto.CrewmateCompleteTaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrewmateServiceImpl implements CrewmateService {

    @Override
    public void changeLocation(ChangeLocationDto crewmateChangeLocationDto) {

    }

    @Override
    public void completeTask(CrewmateCompleteTaskDto crewmateCompleteTaskDto) {

    }
}
