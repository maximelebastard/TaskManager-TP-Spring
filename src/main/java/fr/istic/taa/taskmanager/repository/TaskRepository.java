package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}