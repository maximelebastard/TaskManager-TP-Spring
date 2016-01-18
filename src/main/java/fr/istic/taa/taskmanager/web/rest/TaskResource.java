package fr.istic.taa.taskmanager.web.rest;

import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.repository.TaskRepository;
import fr.istic.taa.taskmanager.service.TaskService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by maxime
 */
@Path("/task")
public class TaskResource extends RestResource<Task, TaskService> {
    public TaskResource() {
        super(new TaskService());
    }
}