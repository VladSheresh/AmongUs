package org.example.dao.api;

import org.example.entity.Crewmate;

import java.util.List;

public interface CrewmateDao extends Dao<Crewmate>{
    List<Crewmate> getAllNotDead();
    List<Crewmate> getAllDead();
}
