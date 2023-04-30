package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Technician;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TechnicianListImplementation implements TechnicianDAO {

    private List<Technician> listOfTechnician;

    public TechnicianListImplementation() {
        this.listOfTechnician = new ArrayList<Technician>();
    }

    @Override
    public Technician create(Technician technician) {
        technician.setID(Generator.generateID());
        this.listOfTechnician.add(technician);
        return technician;
    }

    @Override
    public List<Technician> findMany() {
        List<Technician> technicianList = new ArrayList<Technician>();
        for (Technician technician : this.listOfTechnician) {
            technicianList.add(technician);
        }
        return technicianList;
    }

    @Override
    public Technician findByID(String id) {
        for (Technician technician : this.listOfTechnician) {
            if(technician.getID().equals(id)) {
                return technician;
            }
        }
        return null;
    }

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

    @Override
    public void update(Technician technician) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (this.listOfTechnician.get(i).getID().equals(technician.getID())) {
                this.listOfTechnician.set(i,technician);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed technician is not registered in the system");
    }

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

    @Override
    public void deleteMany() {
        this.listOfTechnician = new ArrayList<>();
    }
}
