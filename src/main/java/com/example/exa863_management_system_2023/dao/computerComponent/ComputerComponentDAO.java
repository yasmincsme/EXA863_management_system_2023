package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.ComputerComponent;

import java.util.List;

public interface ComputerComponentDAO extends CRUD<ComputerComponent, Exception> {

    /**
     * Percorre a lista e retorna o objeto Componente correspondente ao nome informado.
     * @param name Nome do Componente que se deseja encontrar
     * @return Lista com os componentes que possuem o nome informado
     */
    public List<ComputerComponent> findByName(String name);
}
