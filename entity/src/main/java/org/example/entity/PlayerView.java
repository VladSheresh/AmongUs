package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PLAYER_VIEW")

public class PlayerView extends BaseEntity {



    @Column(name="color")
    private Color color;

    @Column(name="hat")
    private boolean hat;

}
