package fr.istic.taa.taskmanager.controller;

import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/epic")
public class EpicController extends RestController<Story, StoryService> {

    @Autowired
    public EpicController(StoryService service) {
        super(service);
    }
}