package com.pos.taskApp.TaskAppBackendSpringboot.repository;

import com.pos.taskApp.TaskAppBackendSpringboot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository

public interface TaskRepo extends JpaRepository<Task,Integer> {
}
