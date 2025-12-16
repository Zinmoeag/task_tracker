package com.taskTracker.tasks.taskModule.application.useCases.impl;

import com.taskTracker.tasks.taskModule.application.converters.TaskListMapper;
import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import com.taskTracker.tasks.taskModule.application.useCases.GetTaskListListUseCase;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import com.taskTracker.tasks.taskModule.application.services.TaskListRespositoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GetTaskListListsUseCaseImpl implements GetTaskListListUseCase {

    private final TaskListRespositoryService taskListRespositoryService;
    private final TaskListMapper taskListMapper;

    @Override
    public List<TaskListDTO> execute() {
        List<TaskListEntity> results = taskListRespositoryService.listsTasksLists();
        List<TaskListDTO> resultsDTO = results.stream().map(taskListMapper::toDTO).collect(Collectors.toList());
        return resultsDTO;
    }
}
