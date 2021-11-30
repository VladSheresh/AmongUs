package org.example.entity;

import lombok.*;
import org.example.entity.enums.Color;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="player_view")
@Builder
public class PlayerView extends BaseEntity {

    @Column(name="color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name="hat")
    private boolean hat;

    @OneToOne(mappedBy = "playerView", fetch = FetchType.EAGER)
    private Imposter imposter;

    @OneToOne(mappedBy = "playerView", fetch = FetchType.EAGER)
    private Crewmate crewmate;
}
