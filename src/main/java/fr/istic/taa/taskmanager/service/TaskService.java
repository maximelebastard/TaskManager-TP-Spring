package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends BaseService<Task, TaskRepository> {

    @Autowired
    public TaskService(TaskRepository repository) {
        super(repository);
    }
}
