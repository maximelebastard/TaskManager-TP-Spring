package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.repository.SprintRepository;
import fr.istic.taa.taskmanager.repository.StoryRepository;

public class StoryService extends BaseService<Story, StoryRepository> {
    public StoryService() {
        super(new StoryRepository());
    }
}
