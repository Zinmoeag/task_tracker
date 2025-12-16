package com.taskTracker.tasks.taskModule.application.services.impl;

import com.taskTracker.tasks.taskModule.domain.exception.TaskListNotFoundExecption;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskEntity;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import com.taskTracker.tasks.taskModule.application.port.TaskListRespository;
import com.taskTracker.tasks.taskModule.application.services.TaskListRespositoryService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TaskListRespositoryServiceImpl implements TaskListRespositoryService {

    private final TaskListRespository taskListRespository;

    @Override
    public List<TaskListEntity> listsTasksLists() {
        return taskListRespository.findAll();
    }

    @Override
    public Optional<TaskListEntity> getTaskListById(UUID id) {
        return taskListRespository.findById(id);
    }

    @Override
    public Optional<TaskListEntity> getTaskListByName(String name) {
        return taskListRespository.findByTitle(name);
    }

    @Override
    public TaskListEntity createTaskList(TaskListEntity taskListEntity) {
        System.out.println(taskListEntity + "insert ================================");
        return taskListRespository.save(taskListEntity);
    }
}
