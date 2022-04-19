package com.example.task16.service;

import java.util.List;

public interface CrudService<T> {

    T findById(Long id);

    List<T> findAll();

    void save(T entity);

    void deleteById(Long id);

}