package org.senai.m2s06.task.service;

import org.senai.m2s06.task.database.Database;
import org.senai.m2s06.task.exception.NotFoundException;
import org.senai.m2s06.task.model.Task;
import org.senai.m2s06.task.model.enums.PriorityEnum;
import org.senai.m2s06.task.model.enums.StatusEnum;
import org.senai.m2s06.task.model.transport.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public TaskDTO create(TaskDTO taskDTO) {
        Task task = new Task(taskDTO);
        Database.add(task);
        return new TaskDTO(task);
    }

    public List<TaskDTO> listAll(StatusEnum status, PriorityEnum priority, String assigneeName) {
        List<Task> tasks = Database.listAll();

        if (status != null) {
            return tasks.stream().filter(task -> task.getStatus().equals(status))
                    .map(TaskDTO::new).toList();
        }

        if (priority != null) {
            return tasks.stream()
                    .filter(task -> task.getPriority().equals(priority))
                    .map(TaskDTO::new).toList();
        }

        if (assigneeName != null) {
            return tasks.stream()
                    .filter(task -> task.getAssigneeName().equalsIgnoreCase(assigneeName))
                    .map(TaskDTO::new).toList();
        }

        return tasks.stream()
                .map(TaskDTO::new).toList();
    }

    public TaskDTO update(Integer id, TaskDTO taskDTO) throws NotFoundException {
        Task task = Database.get(id);
        task.setAssigneeName(taskDTO.assigneeName() != null && !taskDTO.assigneeName().isBlank() ? taskDTO.assigneeName() : task.getAssigneeName());
        task.setDescription(taskDTO.description() != null && !taskDTO.description().isBlank() ? taskDTO.description() : task.getDescription());
        task.setPriority(taskDTO.priority() != null ? taskDTO.priority() : task.getPriority());
        task.setStatus(taskDTO.status() != null ? taskDTO.status() : task.getStatus());

        return new TaskDTO(task);
    }

    public void delete(Integer id) {
        Database.remove(id);
    }
}
