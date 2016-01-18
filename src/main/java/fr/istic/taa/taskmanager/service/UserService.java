package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.domain.User;
import fr.istic.taa.taskmanager.repository.TaskRepository;
import fr.istic.taa.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
}
