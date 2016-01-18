package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.repository.StoryRepository;
import fr.istic.taa.taskmanager.repository.TaskRepository;

public class TaskService extends BaseService<Task, TaskRepository> {
    public TaskService(){
        super(new TaskRepository());
    }
}
