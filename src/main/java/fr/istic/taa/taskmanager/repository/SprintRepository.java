package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.Sprint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Long> {
}
