package com.profesional.tasks.repositories;

import com.profesional.tasks.models.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class TaskRepositoryTest {


    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void BusquedaNombreYActivoValida(){
        Task newTask= new Task();
        newTask.setName("tareaPrueba");
        newTask.setActive(true);
        taskRepository.save(newTask);
        //buscar por la query creada

        Optional<Task> taskFound= taskRepository.buscarNombreYActivo("tareaPrueba",true);
        Task taskEntity= taskFound.get();
        assertTrue(taskFound.isPresent());

    }

    @Test
    public void BusquedaNombreYActivoNoValida(){
        Task newTask= new Task();
        newTask.setName("tareaPrueba");
        newTask.setActive(true);
        taskRepository.save(newTask);
        //buscar por la query creada

        Optional<Task> taskFound= taskRepository.buscarNombreYActivo("otraTarea",true);
        assertFalse(taskFound.isPresent());

        taskFound= taskRepository.buscarNombreYActivo("tareaPrueba",false);
        assertFalse(taskFound.isPresent());

    }


}