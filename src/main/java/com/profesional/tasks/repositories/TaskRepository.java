package com.profesional.tasks.repositories;

import com.profesional.tasks.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

     Optional<Task> findByName(String name);

     @Query("SELECT t FROM Task t WHERE t.name=:name AND t.active= :active")
     Optional<Task> buscarNombreYActivo(@Param("name") String name, @Param("active") boolean active);
}
