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
@Table(name = "location")

public class Location extends BaseEntity {

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @Column(name = "is_dead_body")
    private boolean isDeadBody;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Imposter> imposters;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Crewmate> crewmates;

}
