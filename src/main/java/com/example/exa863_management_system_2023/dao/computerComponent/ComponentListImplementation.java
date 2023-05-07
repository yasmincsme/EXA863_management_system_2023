package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class ComponentListImplementation implements ComputerComponentDAO {

    private List<ComputerComponent> stock;

    public ComponentListImplementation() {
        this.stock = new ArrayList<ComputerComponent>();
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param component Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setID(Generator.generateID());
        this.stock.add(component);
        return component;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<ComputerComponent> findMany() {
        return stock;
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public ComputerComponent findByID(String id) {
        for (ComputerComponent component : this.stock) {
            if (component.getID().equals(id)) {
                return component;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna o objeto Componente correspondente ao nome informado.
     * @param name Nome do Componente que se deseja encontrar
     * @return Lista com os componentes que possuem o nome informado
     */
    @Override
    public List<ComputerComponent> findByName(String name) {
        List<ComputerComponent> componentList = new ArrayList<ComputerComponent>();
        for (ComputerComponent component : this.stock) {
            if(component.getName().equals(name)) {
                componentList.add(component);
            }
        }
        return componentList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param component Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(ComputerComponent component) throws ObjectNotFoundException {
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getID().equals(component.getID())) {
                this.stock.set(i, component);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.stock.size(); i++) {
            if (this.stock.get(i).getID().equals(id)) {
                this.stock.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed component is not registered in the system");
    }

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        this.stock = new ArrayList<>();
    }
}
