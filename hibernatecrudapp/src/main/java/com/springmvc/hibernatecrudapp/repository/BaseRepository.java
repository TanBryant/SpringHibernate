package com.springmvc.hibernatecrudapp.repository;

import java.util.List;

public interface BaseRepository<T> {
    
    public List<T> getAll();

    public void save(T object);

    public T getById(int id);

    public void deleteById(int id);
}
