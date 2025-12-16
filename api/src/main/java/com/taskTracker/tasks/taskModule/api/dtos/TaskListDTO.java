package com.taskTracker.tasks.taskModule.api.dtos;

import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskProrityEntity;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskStatusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskListDTO {
    private String title;

    private String dueDate;

    private String completedDate;

    private String description;

    private Integer count;

    private Double progress;

    private List<TaskDTO>  tasks;

    private LocalDateTime created;

    private LocalDateTime updated;
}
