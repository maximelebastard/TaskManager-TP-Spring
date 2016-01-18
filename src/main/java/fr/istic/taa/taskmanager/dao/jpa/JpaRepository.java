package fr.istic.taa.taskmanager.dao.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: augusto Date: 03/04/2011 Time: 18:50
 */
public interface JpaRepository <T, PK extends Serializable> {

    /**
     * save an entity. This can be either a INSERT or UPDATE in the database.
     *
     * @param entity the entity to save
     *
     * @return the saved entity
     */
    T save(T entity);


    /**
     * Find an entity by its primary key
     *
     * @param id the primary key
     * @return the entity
     */
    T findById(PK id);

    /**
     * Load all entities.
     *
     * @return the list of entities
     */
    List<T> findAll();


    /**
     * Find using a named query.
     *
     * @param queryName the name of the query
     * @param params the query parameters
     *
     * @return the list of entities
     */
    List<T> findByNamedQuery(String queryName, Object... params);

    /**
     * Find using a named query.
     *
     * @param queryName the name of the query
     * @param params the query parameters
     *
     * @return the list of entities
     */
    List<T> findByNamedQueryAndNamedParams(String queryName, Map<String, ?> params);

    /**
     * Count all entities.
     *
     * @return the number of entities
     */
    int countAll();

    /**
     * Merge the state of the given entity into the current persistence context, this will also save the entity.
     *
     * @param entity the entity to save
     *
     * @return the saved entity
     */
    T merge(T entity);


    /**
     * delete an entity from the database.
     *
     * @param entity the entity to delete
     */
    void delete(T entity);
}