package fr.istic.taa.taskmanager.repository;

import fr.istic.taa.taskmanager.domain.BaseEntity;
import fr.istic.taa.taskmanager.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Base repository
 * @param <Entity> The entity concerned by the repository
 */
public abstract class BaseRepository<Entity> {

    /**
     * Entity manager factory
     */
    protected EntityManagerFactory factory;

    /**
     * Entity Manager
     */
    protected EntityManager em;

    /**
     * The class type
     */
    protected Class<Entity> classType;

    /**
     * Initializes the entity manager and fetches the Class Type
     */
    public BaseRepository() {
        this.factory = Persistence.createEntityManagerFactory("mysqllocal");
        this.em = factory.createEntityManager();

        this.classType = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Finds all the entities
     * @return List of all entities
     */
    public List<Entity> findAll() {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        List<Entity> items = new ArrayList<Entity>();
        try {
            items = em.createQuery("SELECT items FROM " + this.classType.getName() + " items", this.classType)
                    .getResultList();
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    /**
     * Finds one entity from its id
     * @param id The entity id
     * @return The entity object
     */
    public Entity findOneById(Long id) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        Entity item = null;
        try {
            item = em.createQuery("SELECT item " +
                    "FROM " + this.classType.getName() + " item " +
                    "WHERE id=:id", this.classType)
                    .setParameter("id", id)
                    .getSingleResult();
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    /**
     * Persists an entity in database
     * @param t Entity to persist
     */
    public void persist(Entity t){
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        try {
            em.persist(t);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Removes an entity in database
     * @param t Entity to remove
     */
    public void remove(Entity t){
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        try {
            em.remove(t);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Merges an entity
     * @param t Entity to merge
     */
    public void merge(Entity t){
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        try {
            em.merge(t);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
    }
}
