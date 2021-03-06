package fr.istic.taa.taskmanager.rest;

import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/task")
public class TaskResource extends RestResource<Task, TaskService> {

    @Autowired
    public TaskResource(TaskService service) {
        super(service);
    }
}