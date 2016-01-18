package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.Sprint;
import org.springframework.data.repository.CrudRepository;

public interface SprintRepository extends CrudRepository<Sprint, Long> {
}
