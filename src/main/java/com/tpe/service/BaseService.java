package com.tpe.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(long id);
    T save(T entity);
    void delete(long id);
    void update(T entity);
}