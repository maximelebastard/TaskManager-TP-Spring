package fr.istic.taa.taskmanager.web.rest;

import fr.istic.taa.taskmanager.domain.User;
import fr.istic.taa.taskmanager.service.UserService;

import javax.ws.rs.Path;

/**
 * Created by maxime
 */
@Path("/user")
public class UserResource extends RestResource<User, UserService> {
    public UserResource() {
        super(new UserService());
    }
}
