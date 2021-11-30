package org.example.service.impl;

import org.example.dao.api.TaskDao;
import org.example.entity.Task;
import org.example.service.api.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractService<Task, TaskDao> implements TaskService {

}
