package com.profesional.tasks.services;


import com.profesional.tasks.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Task createTask(Task task);
    public Task findByName(String name);

    List<Task> AllTaskActive();

    Boolean deleteTask(String name);

    Task updateTask(String name, String description, Boolean active, Boolean complete);

}
