package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
