package com.taskTracker.tasks.taskModule.api.dtos;

import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskProrityEntity;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskStatusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private String title;

    private String description;

    private String dueDate;

    private String completedDate;

    private TaskStatusEntity status;

    private TaskProrityEntity priority;

    private LocalDateTime created;

    private LocalDateTime updated;
}
