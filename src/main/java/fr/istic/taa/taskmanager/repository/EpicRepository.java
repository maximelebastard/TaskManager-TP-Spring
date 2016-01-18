package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.Epic;
import fr.istic.taa.taskmanager.domain.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepository extends CrudRepository<Epic, Long> {
}
