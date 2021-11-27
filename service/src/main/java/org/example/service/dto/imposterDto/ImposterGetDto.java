package org.example.service.dto.imposterDto;

import lombok.Builder;
import lombok.Data;
import org.example.service.dto.AbstractDto;
import org.example.service.dto.commanDto.LocationDto;
import org.example.service.dto.commanDto.PlayerViewDto;

@Builder
@Data
public class ImposterGetDto extends AbstractDto {
    private Long id;
    private String nickname;
    private PlayerViewDto imposterPlayerViewDto;
    private LocationDto location;
}
