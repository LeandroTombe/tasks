package com.profesional.tasks;

import com.profesional.tasks.models.Task;
import com.profesional.tasks.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TasksApplicationTests {


	@Autowired
	private TaskRepository taskRepository;
	@Mock
	private TaskRepository taskMockRepository;


	@BeforeEach
	public void setUp(){
		// Define el comportamiento del repositorio simulado en el método @Before
		Task tasks = new Task();
		tasks.setName("mockTask");
		tasks.setComplete(false);
		tasks.setActive(true);
		tasks.setDescription("Units test before to initialize the app");
		when(taskMockRepository.findByName("mockTask")).thenReturn(Optional.of(tasks));
	}

	@Test
	@DisplayName("create Task")
	public void testSaveTask(){
		//create task and save in database
		Task newTask= new Task();
		newTask.setName("firstTask");
		newTask.setDescription("Only is a task for test");
		newTask.setActive(true);
		newTask.setComplete(false);

		taskRepository.save(newTask);
		//find task
		Optional<Task> findTask= taskRepository.findByName("firstTask");
		//asserts
		assertTrue(findTask.isPresent());
		Task retrieveTask= findTask.get();
		assertEquals("firstTask", retrieveTask.getName());

	}

	@Test
	@DisplayName("Delete Task")
	public void DeleteTask(){
		Optional<Task> foundTask = taskMockRepository.findByName("mockTask");

		assertTrue(foundTask.isPresent());

		// Delete the tasks
		taskRepository.delete(foundTask.get());

		// verify the task has been deleted
		assertEquals(taskRepository.findAll().size(), 0);


	}





}
