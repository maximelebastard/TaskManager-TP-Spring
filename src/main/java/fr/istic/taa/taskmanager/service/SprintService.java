package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService extends BaseService<Sprint, SprintRepository> {

    @Autowired
    public SprintService(SprintRepository repository) {
        super(repository);
    }
}
