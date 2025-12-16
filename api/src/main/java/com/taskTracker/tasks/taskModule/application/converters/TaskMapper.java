package com.taskTracker.tasks.taskModule.application.converters;

import com.taskTracker.tasks.taskModule.api.dtos.TaskDTO;
import org.springframework.scheduling.config.Task;

public interface TaskMapper {
    TaskDTO toDTO(Task task);
    Task toEntity(TaskDTO taskDTO);
}
