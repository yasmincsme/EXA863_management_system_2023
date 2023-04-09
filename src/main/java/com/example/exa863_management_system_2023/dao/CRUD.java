package com.example.exa863_management_system_2023.dao;

import java.util.List;

public interface CRUD<T, E extends Exception> {

    public T create(T object);

    public T findByID(int id);

    public List<T> findMany();

    public void update(T object) throws E;

    public void delete(int id) throws E;

    public void deleteMany();
}
