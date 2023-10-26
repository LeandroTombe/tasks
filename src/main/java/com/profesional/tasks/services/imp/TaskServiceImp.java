package com.profesional.tasks.services.imp;

import com.profesional.tasks.models.Task;
import com.profesional.tasks.repositories.TaskRepository;
import com.profesional.tasks.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {
    
    TaskRepository taskRepository;


    TaskServiceImp( TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }
    


    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findByName(String name) {
        return null;
    }

    @Override
    public List<Task> AllTaskActive() {

        List<Task> allTaskActive= taskRepository.findAll();
        allTaskActive.stream()
                .filter(task -> task.getActive().equals(true))
                .collect(Collectors.toList());

        return allTaskActive;
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
