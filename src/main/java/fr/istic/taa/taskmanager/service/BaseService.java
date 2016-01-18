package fr.istic.taa.taskmanager.service;

import org.springframework.data.repository.CrudRepository;

/**
 * A base service
 * @param <Entity>      Entity represented by the service
 * @param <Repository>  The service repository
 */
public abstract class BaseService<Entity, Repository extends CrudRepository> {

    Repository repository;

    public Iterable<Entity> findAll(){
        return repository.findAll();
    }

    public Entity findOneById(Long id){
        return (Entity) repository.findOne(id);
    }

    public void create(Entity entity) {
        repository.save(entity);
    }

    public void update(Long id, Entity entity) {
        Entity oldEntity = this.findOneById(id);

        repository.save(oldEntity);
    }

    public void removeOneById(Long id){
        Entity entity = (Entity) repository.findOne(id);
        repository.delete(entity);
    }
}
