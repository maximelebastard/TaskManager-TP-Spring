package fr.istic.taa.taskmanager.service;

import fr.istic.taa.taskmanager.domain.BaseEntity;
import fr.istic.taa.taskmanager.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

/**
 * A base service
 * @param <Entity>      Entity represented by the service
 * @param <Repository>  The service repository
 */
public abstract class BaseService<Entity, Repository extends BaseRepository> {

    Repository repository;

    public BaseService(Repository repository) {
        this.repository = repository;
    }

    public List<Entity> findAll(){
        return repository.findAll();
    }

    public Entity findOneById(Long id){
        return (Entity) repository.findOneById(id);
    }

    public void create(Entity entity) {
        repository.persist(entity);
    }

    public void update(Long id, Entity entity) {
        Entity oldEntity = this.findOneById(id);

        repository.persist(oldEntity);
    }

    public void removeOneById(Long id){
        Entity entity = (Entity) repository.findOneById(id);
        repository.remove(entity);
    }
}
