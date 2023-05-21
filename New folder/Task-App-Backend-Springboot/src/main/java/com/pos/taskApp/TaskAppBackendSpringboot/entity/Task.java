package com.pos.taskApp.TaskAppBackendSpringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @Column(name = "task_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskID;

    @Column(name = "title",length = 45)
    private String title;

    @Column(name = "description",length = 45)
    private String description;

    @Column(name = "due_date",length = 45)
    private Date dueDate;

    @Column(name = "status",length = 45)
    private String status;
}
