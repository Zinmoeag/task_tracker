package com.taskTracker.tasks.taskModule.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "task_lists")
public class TaskListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "taskList", cascade = {
          CascadeType.REMOVE, CascadeType.PERSIST
    })
    private List<TaskEntity> tasks;

    @Column(name = "created_At", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated_At",  nullable = false)
    private LocalDateTime updated;
}
