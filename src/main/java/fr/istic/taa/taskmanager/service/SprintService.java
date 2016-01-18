package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.repository.SprintRepository;

public class SprintService extends BaseService<Sprint, SprintRepository> {
    public SprintService() {
        super(new SprintRepository());
    }
}
