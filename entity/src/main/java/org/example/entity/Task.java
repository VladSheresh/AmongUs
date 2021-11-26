package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TASK")

public class Task extends BaseEntity{

  //  @ManyToOne(fetch=FetchType.LAZY)
  //  @JoinColumn(name="location_id")
    private Location location;

}
