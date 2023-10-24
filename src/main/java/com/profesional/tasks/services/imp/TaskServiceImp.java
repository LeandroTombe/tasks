package com.profesional.tasks.services.imp;

import com.profesional.tasks.models.Task;
import com.profesional.tasks.services.TaskService;

import java.util.List;

public class TaskServiceImp implements TaskService {


    @Override
    public Task createTask(String name, String description, Boolean active, Boolean complete) {
        return null;
    }

    @Override
    public Task findByName(String name) {
        return null;
    }

    @Override
    public List<Task> AllTaskActive() {
        return null;
    }

    @Override
    public Boolean deleteTask(String name) {
        return null;
    }

    @Override
    public Task updateTask(String name, String description, Boolean active, Boolean complete) {
        return null;
    }
}
