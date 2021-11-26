package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="player_view")

public class PlayerView extends BaseEntity {

    @Column(name="color")
    private Color color;

    @Column(name="hat")
    private boolean hat;

    @OneToOne(mappedBy = "playerView", fetch = FetchType.LAZY)
    private Imposter imposter;

    @OneToOne(mappedBy = "playerView", fetch = FetchType.LAZY)
    private Crewmate crewmate;
}
