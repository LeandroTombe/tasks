package com.profesional.tasks.services.imp;

import com.profesional.tasks.models.Task;
import com.profesional.tasks.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceImpTest {

    @InjectMocks
    private TaskServiceImp taskServiceImp;

    @Mock
    private  TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa las anotaciones Mockito
        Task task= new Task("testServiceName", "testServiceDescription",true,true);
        Mockito.when(taskRepository.findByName("testServiceName")).thenReturn(Optional.of(task));
    }

    @Test
    public void testFindTaskByName() {
        String name = "testServiceName";
        Optional<Task> taskOptional = taskServiceImp.findByName(name);

        // Asegúrate de que el Optional contiene un valor y que coincide con el valor simulado
        assertTrue(taskOptional.isPresent());
        assertEquals(name, taskOptional.get().getName());
    }
}