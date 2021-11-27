package org.example.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="crewmate")
@Builder
public class Crewmate extends Player{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "crewmate_task",
            joinColumns = @JoinColumn(name = "crewmate_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    @Column(name = "is_dead")
    private boolean isDead;
}
