package org.example.dao.api;

import org.example.entity.Task;

import java.util.List;

public interface TaskDao extends Dao<Task>{
    List<Task> getAllNotCompleteTask();
}
