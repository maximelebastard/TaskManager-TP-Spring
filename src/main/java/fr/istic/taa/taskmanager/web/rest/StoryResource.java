package fr.istic.taa.taskmanager.web.rest;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.service.SprintService;
import fr.istic.taa.taskmanager.service.StoryService;

import javax.ws.rs.Path;

/**
 * Created by maxime
 */
@Path("/story")
public class StoryResource extends RestResource<Story, StoryService> {
    public StoryResource() {
        super(new StoryService());
    }
}