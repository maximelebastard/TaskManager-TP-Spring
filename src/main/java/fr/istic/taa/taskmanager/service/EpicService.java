package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.Epic;
import fr.istic.taa.taskmanager.domain.Story;
import fr.istic.taa.taskmanager.repository.EpicRepository;
import fr.istic.taa.taskmanager.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpicService extends BaseService<Epic, EpicRepository> {

    @Autowired
    public EpicService(EpicRepository repository) {
        super(repository);
    }
}
