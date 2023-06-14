package com.hibernateexample.repositories;

import java.util.List;

public interface IRepository<T> {

    void save(T t);

    void update(T t);

    T getById(long id);

    List<T> getAll();

    void delete(long id);

}