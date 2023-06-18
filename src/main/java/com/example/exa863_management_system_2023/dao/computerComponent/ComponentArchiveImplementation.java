package com.example.exa863_management_system_2023.dao.computerComponent;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.ComputerComponent;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class ComponentArchiveImplementation implements ComputerComponentDAO {
    private List<ComputerComponent> stock;
    private FileManager<String> fileManager;

    public ComponentArchiveImplementation() {
        fileManager = new FileManager<>("components.dat");
        stock = FileManager.readListFromFile("components.dat");
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param component Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public ComputerComponent create(ComputerComponent component) {
        component.setID(Generator.generateID());
        stock.add(component);
        FileManager.writeListToFile(stock, "components.dat");
        return component;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<ComputerComponent> findMany() {
        return FileManager.readListFromFile("components.dat");
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
                FileManager.writeListToFile(stock, "components.dat");
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
            if (stock.get(i).getID().equals(id)) {
                stock.remove(i);
                FileManager.writeListToFile(stock, "components.dat");
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
        stock = new ArrayList<>();
        FileManager.writeListToFile(stock, "components.dat");
    }
}
