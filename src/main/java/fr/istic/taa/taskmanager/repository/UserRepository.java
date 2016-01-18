package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
