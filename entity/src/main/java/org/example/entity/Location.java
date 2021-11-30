package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
@Builder
public class Location extends BaseEntity {

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List<Task> tasks;

    @Column(name = "is_dead_body")
    private boolean isDeadBody;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List<Imposter> imposters;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List<Crewmate> crewmates;

}
