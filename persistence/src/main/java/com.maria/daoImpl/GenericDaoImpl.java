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


    public T get(int id) {

        return entityManager.find(type, id);

    }


    public List<T> getAll() {
        return entityManager.createQuery("from " + type.getName()).getResultList();
    }


    public T persist(T object) {
        entityManager.persist(object);
        return object;
    }

    public void delete(int id) {
        T object = get(id);
        if(object !=null){
            entityManager.remove(object);
        }
    }
}
