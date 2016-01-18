package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.repository.SprintRepository;
import fr.istic.taa.taskmanager.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService extends BaseService<Story, StoryRepository> {

    @Autowired
    public StoryService(StoryRepository repository) {
        super(repository);
    }
}
