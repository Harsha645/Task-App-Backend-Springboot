package com.pos.taskApp.TaskAppBackendSpringboot.controller;

import com.pos.taskApp.TaskAppBackendSpringboot.dto.TaskDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.dto.request.TaskSaveRequestDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.dto.request.TaskUpdateRequestDTO;
import com.pos.taskApp.TaskAppBackendSpringboot.service.TaskService;
import com.pos.taskApp.TaskAppBackendSpringboot.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody TaskSaveRequestDTO taskSaveRequestDTO){
        String id = taskService.addTask(taskSaveRequestDTO);
        //System.out.println(taskSaveRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id + " item successfully saved",id),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path =
            {"/get-all-tasks"}
    )
    public ResponseEntity<StandardResponse> getAllTasks() {
        List<TaskDTO> allTasks = taskService.getAllTasks();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, " success",allTasks),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-by-id/{taskID}")
    public ResponseEntity<StandardResponse> deleteTaskById(@PathVariable(value = "taskID") int taskID) {
        //System.out.println("deleted");
        //System.out.println(taskID);

        String deleted = taskService.deleteTaskById(taskID);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, " success", deleted),
                HttpStatus.OK
        );
    }
    @PutMapping(path = "/update/{taskID}")
    public ResponseEntity<StandardResponse> updateTask(@PathVariable(value = "taskID") int taskID, @RequestBody TaskUpdateRequestDTO taskUpdateRequestDTO){
        System.out.println("updated");
        String updated = taskService.updateTask(taskUpdateRequestDTO);


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, " success",updated),
                HttpStatus.OK
        );

    }


}
