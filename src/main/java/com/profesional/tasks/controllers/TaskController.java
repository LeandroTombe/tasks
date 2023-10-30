package com.profesional.tasks.controllers;


import com.profesional.tasks.Exceptions.UserNotFoundException;
import com.profesional.tasks.models.Task;
import com.profesional.tasks.services.TaskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/task")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private TaskService taskService;

    TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask( @RequestBody @Valid Task newTask){
        Task createdTask= taskService.createTask(newTask);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);

    }

    @GetMapping("/allTask")
    public ResponseEntity<List<Task>> allTaskActive(){
        List<Task> AllTaskActive= taskService.AllTaskActive();
        logger.info("Obteniendo las tareas activas desde el controlador");
        return ResponseEntity.status(HttpStatus.OK).body(AllTaskActive);
    }

    @GetMapping("/{taskName}")
    public ResponseEntity<?> getTaskByName(@PathVariable String taskName){
        Optional<Task> taskOptional = taskService.findByName(taskName);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            return ResponseEntity.ok(task); // Usuario encontrado, respuesta exitosa
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("tarea: " + taskName + " no encontrado"); // Usuario no encontrado, código de estado 404 (Not Found)// Usuario no encontrado, respuesta 404
        }
    }
}
