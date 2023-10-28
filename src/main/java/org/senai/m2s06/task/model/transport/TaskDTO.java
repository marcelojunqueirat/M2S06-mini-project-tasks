package org.senai.m2s06.task.model.transport;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.senai.m2s06.task.model.Task;
import org.senai.m2s06.task.model.enums.PriorityEnum;
import org.senai.m2s06.task.model.enums.StatusEnum;

public record TaskDTO(Integer id, @NotBlank String description, @NotNull StatusEnum status,
                      @NotNull PriorityEnum priority, @NotBlank String assigneeName) {
    public TaskDTO(Task task) {
        this(task.getId(), task.getDescription(), task.getStatus(), task.getPriority(), task.getAssigneeName());
    }
}

