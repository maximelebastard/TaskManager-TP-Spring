package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, Long> {
}
