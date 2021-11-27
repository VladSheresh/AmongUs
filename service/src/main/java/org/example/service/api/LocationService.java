package org.example.service.api;

import org.example.entity.Location;
import org.example.service.dto.locationDto.DeadBodyDto;
import org.example.service.dto.locationDto.LocationCreateDto;
import org.example.service.dto.locationDto.LocationGetDto;
import org.example.service.dto.locationDto.LocationUpdateDto;

public interface LocationService extends Service <Location, LocationCreateDto, LocationUpdateDto, LocationGetDto> {

    void deadBodyLocation(DeadBodyDto deadBody);

}
