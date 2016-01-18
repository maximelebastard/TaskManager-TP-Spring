package fr.istic.taa.taskmanager.controller;

import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/task")
public class TaskController extends RestController<Task, TaskService> {

    @Autowired
    public TaskController(TaskService service) {
        super(service);
    }
}