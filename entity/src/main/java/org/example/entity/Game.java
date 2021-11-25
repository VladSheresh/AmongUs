package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="GAME")

public class Game extends Player {

    @Column(name="task_count")
    private int taskCount;
    private int crewmateCount;
    private int imposterCount;

   // private Location voteLocation;

}
