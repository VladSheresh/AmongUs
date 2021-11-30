package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor //должен быть пустой конструктор
@SuperBuilder(toBuilder = true) //надо для абстрактного сервиса
public abstract class Player extends BaseEntity {

    @Column(name = "nick_name")
    private String nickname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_view_id")
    private PlayerView playerView;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "is_dead")
    private boolean isDead;
}
