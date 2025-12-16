package com.taskTracker.tasks.taskModule.application.converters;

import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;

public interface TaskListMapper {
    TaskListDTO toDTO(TaskListEntity task);
    TaskListEntity toEntity(TaskListDTO taskDTO);
}
