package com.maria.dao;

import java.util.List;

/**
 * Created by msimion on 8/28/2015.
 */
public interface GenericDao<T extends Object>{

    public T get(int id);
    public List<T> getAll();
    public T persist(T object);
    public void delete(int id);

}
