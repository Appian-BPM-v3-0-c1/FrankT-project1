package com.project1.daos;

import java.util.List;

public interface CrudDAO <T> {

    void save(T obj);
    List<T> findAll();
    T findById(String id);
    boolean update(T updateObj);
    boolean removeById(String id);

}