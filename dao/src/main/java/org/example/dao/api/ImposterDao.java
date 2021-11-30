package org.example.dao.api;

import org.example.entity.Imposter;

import java.util.List;

public interface ImposterDao extends Dao<Imposter>{
    List<Imposter> getAllNotDead();
    List<Imposter> getAllDead();
}
