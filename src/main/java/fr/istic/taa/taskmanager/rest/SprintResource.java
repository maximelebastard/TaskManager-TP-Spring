package fr.istic.taa.taskmanager.rest;

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
public class SprintResource extends RestResource<Sprint, SprintService> {

    @Autowired
    public SprintResource(SprintService service) {
        super(service);
    }
}