package com.pos.taskApp.TaskAppBackendSpringboot.service.impl;

import com.pos.taskApp.TaskAppBackendSpringboot.dto.TaskDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.dto.request.TaskSaveRequestDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.dto.request.TaskUpdateRequestDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.entity.Task;
import com.pos.taskApp.TaskAppBackendSpringboot.exception.EntryDuplicationException;
import com.pos.taskApp.TaskAppBackendSpringboot.repository.TaskRepo;
import com.pos.taskApp.TaskAppBackendSpringboot.service.TaskService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String addTask(TaskSaveRequestDTO taskSaveRequestDTO) {
        Task task = modelMapper.map(taskSaveRequestDTO,Task.class);
        task.setStatus("done");

        if (!taskRepo.existsById(task.getTaskID())){
            taskRepo.save(task);
            return taskRepo.save(task).getTitle();
        }else {
            throw new EntryDuplicationException("Already in the database");
        }


    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> getTasks = taskRepo.findAll();
        List<TaskDTO> taskDTOS = modelMapper.map(getTasks, new TypeToken<List<TaskDTO>>(){}.getType()
        );
        return taskDTOS;


    }

    @Override
    public String deleteTaskById(int id) {
        if(taskRepo.existsById(id)){
            taskRepo.deleteById(id);
            return "deleted";
        }
        return null;
    }

    @Override
    public String updateTask(TaskUpdateRequestDTO taskUpdateRequestDTO) {
        if(taskRepo.existsById(taskUpdateRequestDTO.getTaskID())){
            Task task = taskRepo.getById(taskUpdateRequestDTO.getTaskID());

            task.setTitle(taskUpdateRequestDTO.getTitle());
            task.setDescription(taskUpdateRequestDTO.getDescription());
            task.setDueDate(taskUpdateRequestDTO.getDueDate());
            task.setStatus(taskUpdateRequestDTO.getStatus());

            taskRepo.save(task);
            return "updated_successful";
        }else {
            return "Not Task Found for this ID";
        }

    }


}
