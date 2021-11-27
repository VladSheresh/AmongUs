package org.example.dao.impl;

import org.example.dao.api.TaskDao;
import org.example.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao {

    @Override
    protected Class<Task> getEntityClass() {
        return Task.class;
    }
}
