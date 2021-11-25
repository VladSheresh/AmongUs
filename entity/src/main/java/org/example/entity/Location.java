package org.example.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Location extends BaseEntity{

    private String locationName;
    private List<Player> players;
    private List<Task> tasks;
}
