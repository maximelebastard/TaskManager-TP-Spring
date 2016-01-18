package fr.istic.taa.taskmanager.web.rest;

import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.service.StoryService;

import javax.ws.rs.Path;

/**
 * Created by maxime
 */
@Path("/epic")
public class EpicResource extends RestResource<Story, StoryService> {
    public EpicResource() {
        super(new StoryService());
    }
}