package com.maria.daoImpl;

import com.maria.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public class GenericDaoImpl<T extends Object> implements GenericDao<T> {

    private Class<T> type;

    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> type) {
        super();
        this.type = type;
    }

    @Transactional
    public T get(Long id) {
        if (id == null) {
            return null;
        } else {
            return entityManager.find(type, id);
        }
    }

    @Transactional
    public List<T> getAll() {
        return entityManager.createQuery("from " + type.getName()).getResultList();
    }

    @Transactional
    public void save(T object) {
        entityManager.persist(object);
    }

    @Transactional
    public void delete(T object) {
        entityManager.remove(object);
    }
}
