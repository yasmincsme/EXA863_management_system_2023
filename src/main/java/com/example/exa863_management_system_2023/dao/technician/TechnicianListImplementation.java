package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.model.Technician;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TechnicianListImplementation implements TechnicianDAO {

    private List<Technician> listOfTechnician;
    private String nextID;

    public TechnicianListImplementation() {
        this.listOfTechnician = new ArrayList<Technician>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public Technician create(Technician technician) {
        technician.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
        this.listOfTechnician.add(technician);
        return technician;
    }

    @Override
    public List<Technician> findMany() {
        List<Technician> technicianList = new ArrayList<Technician>();
        for (Object technician : this.listOfTechnician) {
            technicianList.add((Technician) technician);
        }
        return technicianList;
    }

    @Override
    public Technician findByID(String id) {
        for (Technician technician : this.listOfTechnician) {
            if(Objects.equals(technician.getID(), id)) {
                return technician;
            }
        }
        return null;
    }

    @Override
    public List<Technician> findByName(String name) {
        List<Technician> technicianList = new ArrayList<Technician>();
        for (Technician technician : this.listOfTechnician) {
            if (Objects.equals(technician.getName(), name)) {
                technicianList.add(technician);
            }
        }
        return technicianList;
    }

    @Override
    public void update(Technician technician) throws Exception {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (Objects.equals(this.listOfTechnician.get(i).getID(), technician.getID())) {
                this.listOfTechnician.set(i,technician);
                return;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (Objects.equals(this.listOfTechnician.get(i).getID(), id)) {
                this.listOfTechnician.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfTechnician = new ArrayList<>();
        this.nextID = null;
    }
}
