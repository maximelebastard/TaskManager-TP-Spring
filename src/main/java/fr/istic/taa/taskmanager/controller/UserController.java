package fr.istic.taa.taskmanager.controller;

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
public class UserController extends RestController<User, UserService> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }
}
