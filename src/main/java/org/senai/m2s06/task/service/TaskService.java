package org.senai.m2s06.task.service;

import org.senai.m2s06.task.database.Database;
import org.senai.m2s06.task.model.Task;
import org.senai.m2s06.task.model.transport.TaskDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public TaskDTO create(TaskDTO taskDTO) {
        Task task = new Task(taskDTO);
        Database.add(task);
        return new TaskDTO(task);
    }
}
