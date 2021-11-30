package org.example.controller.dto.imposterDto;

import lombok.Builder;
import lombok.Data;
import org.example.controller.dto.AbstractDto;
import org.example.controller.dto.commanDto.LocationDto;
import org.example.controller.dto.commanDto.PlayerViewDto;

@Builder
@Data
public class ImposterGetDto extends AbstractDto {
    private Long id;
    private String nickname;
    private PlayerViewDto imposterPlayerViewDto;
    private LocationDto location;
    private boolean isDead;
}
