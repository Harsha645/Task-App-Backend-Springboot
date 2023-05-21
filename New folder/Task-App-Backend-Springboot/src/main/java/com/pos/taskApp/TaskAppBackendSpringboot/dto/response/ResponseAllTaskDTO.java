package com.pos.taskApp.TaskAppBackendSpringboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAllTaskDTO {
    private String title;
    private String description;
    private Date dueDate;
    private String status;
}
