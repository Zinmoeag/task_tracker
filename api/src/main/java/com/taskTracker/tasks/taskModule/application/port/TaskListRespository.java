package com.taskTracker.tasks.taskModule.application.port;

import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskListRespository extends JpaRepository<TaskListEntity, UUID> {
    Optional<TaskListEntity> findByTitle(String title);
}
