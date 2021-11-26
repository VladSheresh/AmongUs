package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="crewmate")

public class Crewmate extends Player{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "crewmate_task",
            joinColumns = @JoinColumn(name = "crewmate_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    @Column(name = "is_dead")
    private boolean isDead;
}
