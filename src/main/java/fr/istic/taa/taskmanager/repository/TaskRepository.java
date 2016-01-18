package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}