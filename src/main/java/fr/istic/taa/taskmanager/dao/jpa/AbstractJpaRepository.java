package fr.istic.taa.taskmanager.dao.jpa;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: augusto Date: 03/04/2011 Time: 18:51
 */
public class AbstractJpaRepository<T extends Serializable, PK extends Serializable> implements JpaRepository<T, PK> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractJpaRepository() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Transactional
    public T save(T entity) {
        this.entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public T findById(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Transactional
    public List<T> findAll() {
        return findByCriteria();
    }

    @Transactional
    public List<T> findByNamedQuery(final String name, Object... params) {
        javax.persistence.Query query = entityManager.createNamedQuery(
                name);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        return (List<T>) query.getResultList();
    }

    @Transactional
    public List<T> findByNamedQueryAndNamedParams(final String name, final Map<String, ?> params) {
        javax.persistence.Query query = entityManager.createNamedQuery(
                name);

        for (final Map.Entry<String, ?> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }

        return (List<T>) query.getResultList();
    }

    @Transactional
    public int countAll() {
        return countByCriteria();
    }

    @Transactional
    public T merge(T entity) {
        return this.entityManager.merge(entity);
    }

    @Transactional
    public void delete(T entity) {
        this.entityManager.remove(entity);
    }


    protected List<T> findByCriteria(final Criterion... criterion) {
        return findByCriteria(-1, -1, null, criterion);
    }

    protected List<T> findByCriteria(final int firstResult,
                                     final int maxResults, final Order order, final Criterion... criterion) {
        Session session = (Session) entityManager.getDelegate();
        Criteria crit = session.createCriteria(entityClass);

        for (final Criterion c : criterion) {
            if (c != null) {
                crit.add(c);
            }
        }

        if( order != null ) {
            crit.addOrder(order);
        }

        if (firstResult > 0) {
            crit.setFirstResult(firstResult);
        }

        if (maxResults > 0) {
            crit.setMaxResults(maxResults);
        }

        return crit.list();
    }


    protected int countByCriteria(Criterion... criterion) {
        Session session = (Session) entityManager.getDelegate();
        Criteria crit = session.createCriteria(entityClass);
        crit.setProjection(Projections.rowCount());

        for (final Criterion c : criterion) {
            if (c != null) {
                crit.add(c);
            }
        }

        return ((Long) crit.list().get(0)).intValue();
    }
}
