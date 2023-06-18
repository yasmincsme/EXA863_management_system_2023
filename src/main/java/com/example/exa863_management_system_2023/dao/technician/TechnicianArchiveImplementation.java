package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class TechnicianArchiveImplementation implements TechnicianDAO {
    private List<Technician> listOfTechnicians;
    private FileManager<String> fileManager;

    public TechnicianArchiveImplementation() {
        fileManager = new FileManager<>("technicians.dat");
        listOfTechnicians = FileManager.readListFromFile("technicians.dat");
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param technician Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Technician create(Technician technician) {
        technician.setID(Generator.generateID());
        listOfTechnicians.add(technician);
        FileManager.writeListToFile(listOfTechnicians, "technicians.dat");
        return technician;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Technician> findMany() {
        return FileManager.readListFromFile("technicians.dat");
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Technician findByID(String id) {
        for (Technician technician : this.listOfTechnicians) {
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
        List<Technician> technicianList = new ArrayList<>();
        for (Technician technician : this.listOfTechnicians) {
            if (technician.getName().equals(name)) {
                technicianList.add(technician);
            }
        }
        return technicianList;
    }

    @Override
    public List<Technician> findByLogin(String login) {
        List<Technician> technicianList = new ArrayList<>();
        for (Technician technician : this.listOfTechnicians) {
            if (technician.getLogin().equals(login)) {
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
        for (int i = 0; i < listOfTechnicians.size(); i++) {
            if (listOfTechnicians.get(i).getID().equals(technician.getID())) {
                listOfTechnicians.set(i, technician);
                FileManager.writeListToFile(listOfTechnicians, "technicians.dat");
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
        for (int i = 0; i < this.listOfTechnicians.size(); i++) {
            if (listOfTechnicians.get(i).getID().equals(id)) {
                listOfTechnicians.remove(i);
                FileManager.writeListToFile(listOfTechnicians, "technicians.dat");
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
        listOfTechnicians = new ArrayList<>();
        FileManager.writeListToFile(listOfTechnicians, "technicians.dat");
    }
}
