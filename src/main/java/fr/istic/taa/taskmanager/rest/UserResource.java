package fr.istic.taa.taskmanager.rest;

import fr.istic.taa.taskmanager.domain.User;
import fr.istic.taa.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/user")
public class UserResource extends RestResource<User, UserService> {

    @Autowired
    public UserResource(UserService service) {
        super(service);
    }
}
