package fr.istic.taa.taskmanager.controller;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/sprint")
public class SprintController extends RestController<Sprint, SprintService> {

    @Autowired
    public SprintController(SprintService service) {
        super(service);
    }
}