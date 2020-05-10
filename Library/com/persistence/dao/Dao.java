package com.persistence.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    public List<T> getAll();

    public void add(T obiectGeneric);

    public void remove(long id);

    public Optional<T> findById(long id);
}
