package com.taskTracker.tasks.taskModule.application.converters.impl;

import com.taskTracker.tasks.taskModule.application.converters.TaskListMapper;
import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final ModelMapper modelMapper;

    public TaskListMapperImpl (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskListDTO toDTO(TaskListEntity task) {
        return modelMapper.map(task, TaskListDTO.class);
    }

    @Override
    public TaskListEntity toEntity(TaskListDTO taskDTO) {
        return modelMapper.map(taskDTO, TaskListEntity.class);
    }
}
