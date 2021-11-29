package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.api.CrewmateDao;
import org.example.dao.api.PlayerViewDao;
import org.example.entity.Crewmate;
import org.example.entity.Location;
import org.example.entity.PlayerView;
import org.example.service.api.CrewmateService;
import org.example.service.dto.commanDto.ChangeLocationDto;
import org.example.service.dto.crewmateDto.CrewmateCompleteTaskDto;
import org.example.service.dto.crewmateDto.CrewmateCreateDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrewmateServiceImpl implements CrewmateService {

    private final CrewmateDao dao;
    private final PlayerViewDao playerViewDao;

    @Override
    @Transactional
    public void save(CrewmateCreateDto dto) {

        PlayerView playerViewEntity = new PlayerView ();
        playerViewEntity.setColor(dto.getCrewmatePlayerView().getColor());
        playerViewEntity.setHat(dto.getCrewmatePlayerView().getHat());

        Location location = new Location();
        location.setLocationName(dto.getLocation().getLocationName());

        PlayerView playerViewId = new PlayerView ();
        playerViewId = playerViewDao.getById(dto.getPlayerViewId());

        Crewmate crewmate = Crewmate.builder()
                .nickname(dto.getNickname())
                .playerView(playerViewEntity)
                .playerView(playerViewId)
                .isDead(dto.isDead())
                .location(location)
                .build();
        dao.save(crewmate);

    @Override
    public void changeLocation(ChangeLocationDto crewmateChangeLocationDto) {

    }

    @Override
    public void completeTask(CrewmateCompleteTaskDto crewmateCompleteTaskDto) {

    }
}
