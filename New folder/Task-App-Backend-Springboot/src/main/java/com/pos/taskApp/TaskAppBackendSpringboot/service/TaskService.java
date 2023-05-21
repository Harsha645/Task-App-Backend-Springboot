package com.pos.taskApp.TaskAppBackendSpringboot.service;

import com.pos.taskApp.TaskAppBackendSpringboot.dto.TaskDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.dto.request.TaskSaveRequestDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.dto.request.TaskUpdateRequestDTO;

import java.util.List;

public interface TaskService {


    String addTask(TaskSaveRequestDTO taskSaveRequestDTO);

    List<TaskDTO> getAllTasks();

    String deleteTaskById(int id);


    String updateTask(TaskUpdateRequestDTO taskUpdateRequestDTO);
}
