package org.senai.m2s06.task.controller;

import jakarta.validation.Valid;
import org.senai.m2s06.task.exception.NotFoundException;
import org.senai.m2s06.task.model.enums.PriorityEnum;
import org.senai.m2s06.task.model.enums.StatusEnum;
import org.senai.m2s06.task.model.transport.TaskDTO;
import org.senai.m2s06.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TaskDTO>> list(
            @RequestParam(name = "status", required = false) StatusEnum status,
            @RequestParam(name = "priority", required = false) PriorityEnum priority,
            @RequestParam(name = "owner", required = false) String assigneeName) {
        List<TaskDTO> response = this.taskService.listAll(status, priority, assigneeName);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable("id") Integer id, @RequestBody TaskDTO taskDTO) throws NotFoundException {
        TaskDTO response = this.taskService.update(id, taskDTO);
        return ResponseEntity.ok(response);
    }
}
