package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;


public class TechnicianListImplementation implements TechnicianDAO {

    private List<Technician> listOfTechnician;

    public TechnicianListImplementation() {
        this.listOfTechnician = new ArrayList<Technician>();
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param technician Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Technician create(Technician technician) {
        technician.setID(Generator.generateID());
        this.listOfTechnician.add(technician);
        return technician;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Technician> findMany() {
        return listOfTechnician;
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Technician findByID(String id) {
        for (Technician technician : this.listOfTechnician) {
            if (technician.getID().equals(id)) {
                return technician;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna o objeto Técnico correspondente ao nome informado.
     * @param name Nome do Técnico que se deseja encontrar
     * @return Lista com os técnicos que possuem o nome informado
     */
    @Override
    public List<Technician> findByName(String name) {
        List<Technician> technicianList = new ArrayList<Technician>();
        for (Technician technician : this.listOfTechnician) {
            if (technician.getName().equals(name)) {
                technicianList.add(technician);
            }
        }
        return technicianList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param technician Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(Technician technician) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (this.listOfTechnician.get(i).getID().equals(technician.getID())) {
                this.listOfTechnician.set(i, technician);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed technician is not registered in the system");
    }

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (this.listOfTechnician.get(i).getID().equals(id)) {
                this.listOfTechnician.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed technician is not registered in the system");
    }

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        this.listOfTechnician = new ArrayList<>();
    }
}
