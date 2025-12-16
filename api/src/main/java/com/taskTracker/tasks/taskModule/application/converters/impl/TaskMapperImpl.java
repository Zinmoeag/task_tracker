package com.taskTracker.tasks.taskModule.application.converters.impl;

import com.taskTracker.tasks.taskModule.application.converters.TaskMapper;
import com.taskTracker.tasks.taskModule.api.dtos.TaskDTO;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapperImpl implements TaskMapper {

    private final ModelMapper modelMapper;

    public TaskMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskDTO toDTO(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public Task toEntity(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }
}
