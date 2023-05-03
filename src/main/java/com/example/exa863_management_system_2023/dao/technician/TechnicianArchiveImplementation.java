package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
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

    @Override
    public Technician create(Technician technician) {
        technician.setID(Generator.generateID());
        listOfTechnicians.add(technician);
        FileManager.writeListToFile(listOfTechnicians, "technicians.dat");
        return technician;
    }

    @Override
    public List<Technician> findMany() {
        return FileManager.readListFromFile("technicians.dat");
    }

    @Override
    public Technician findByID(String id) {
        for (Technician technician : this.listOfTechnicians) {
            if (technician.getID().equals(id)) {
                return technician;
            }
        }
        return null;
    }

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

    @Override
    public void deleteMany() {
        listOfTechnicians = new ArrayList<>();
        FileManager.writeListToFile(listOfTechnicians, "technicians.dat");
    }
}
