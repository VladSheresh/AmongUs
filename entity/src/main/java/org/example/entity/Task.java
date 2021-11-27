package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
@Builder
public class Task extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    private List<Crewmate> crewmates;

}
