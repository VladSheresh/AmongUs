package org.example.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.api.TaskDao;
import org.example.entity.Task;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao {

    @Override
    protected Class<Task> getEntityClass() {
        return Task.class;
    }
    @Override
    public List<Task> getAllNotCompleteTask() {
        log.info("Выполняю метод getAllNotCompleteTask, обьект=" + Task.class);
        return entityManager.createQuery(
                "select t from Task t where t.isComplete = false", Task.class
        ).getResultList();
    }

}
