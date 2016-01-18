package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Sprint;
import fr.istic.taa.taskmanager.repository.SprintRepository;
import org.jvnet.hk2.annotations.Service;

@Service
public class SprintService extends BaseService<Sprint, SprintRepository> {
}
