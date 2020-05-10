package com.persistence.dao;

import com.exceptions.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll();
    Optional<T> findById(String id) throws CategoryNotFoundException;
    void remove(String id);
    void add(T t);
}
