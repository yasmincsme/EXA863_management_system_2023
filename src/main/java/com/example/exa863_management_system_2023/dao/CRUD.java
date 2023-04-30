package com.example.exa863_management_system_2023.dao;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;

import java.util.List;

public interface CRUD<T, E extends Exception> {

    public T create(T object);

    public T findByID(String id);

    public List<T> findMany();

    public void update(T object) throws ObjectNotFoundException;

    public void delete(String id) throws ObjectNotFoundException;

    public void deleteMany();
}
