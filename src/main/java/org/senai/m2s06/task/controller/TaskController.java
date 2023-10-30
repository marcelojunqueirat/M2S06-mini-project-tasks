package org.senai.m2s06.task.controller;

import jakarta.validation.Valid;
import org.senai.m2s06.task.model.transport.TaskDTO;
import org.senai.m2s06.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> create(@Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO response = this.taskService.create(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
