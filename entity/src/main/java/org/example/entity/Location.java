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
@Table(name="LOCATION")

public class Location extends BaseEntity{

    @Column(name="location_name")
    private String locationName;

   // @OneToMany(fetch= FetchType.LAZY)
    private List<Task> tasks;

    private boolean isDeadBody;


}
