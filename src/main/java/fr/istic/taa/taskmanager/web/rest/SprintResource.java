package fr.istic.taa.taskmanager.web.rest;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.service.SprintService;
import fr.istic.taa.taskmanager.service.TaskService;

import javax.ws.rs.Path;

/**
 * Created by maxime
 */
@Path("/sprint")
public class SprintResource extends RestResource<Sprint, SprintService> {
    public SprintResource() {
        super(new SprintService());
    }
}