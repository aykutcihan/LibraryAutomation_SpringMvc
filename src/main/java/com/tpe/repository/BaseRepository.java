package com.tpe.repository;

import java.util.List;

public interface BaseRepository<T> {
    List<T> findAll();
    T findById(long id);
    T save(T entity);
    void delete(long id);
    void update(T entity);
}
