package com.example.exa863_management_system_2023.dao;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;

import java.util.List;

public interface CRUD<T, E extends Exception> {

    /**
     * Cria um novo objeto do tipo especificado.
     * @param object Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    public T create(T object);

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    public List<T> findMany();

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    public T findByID(String id);

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param object Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    public void update(T object) throws ObjectNotFoundException;

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    public void delete(String id) throws ObjectNotFoundException;

    /**
     * Deleta todos os elementos da lista
     */
    public void deleteMany();
}
