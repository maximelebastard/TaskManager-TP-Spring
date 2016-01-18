package fr.istic.taa.taskmanager.rest;

import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/story")
public class StoryResource extends RestResource<Story, StoryService> {

    @Autowired
    public StoryResource(StoryService service) {
        super(service);
    }
}