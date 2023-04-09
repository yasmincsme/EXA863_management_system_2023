package com.example.exa863_management_system_2023.dao.technician;

import com.example.exa863_management_system_2023.model.Technician;

import java.util.ArrayList;
import java.util.List;

public class TechnicianListImplementation implements TechnicianDAO{

    private List<Technician> listOfTechnician;
    private int nextID;

    public TechnicianListImplementation() {
        this.listOfTechnician = new ArrayList<Technician>();
        this.nextID = 0;
    }

    @Override
    public Technician create(Technician technician) {
        technician.setId(this.nextID);
        this.nextID++;
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
    public Technician findbyID(int id) {
        for (Technician technician : this.listOfTechnician) {
            if(technician.getId() == id) {
                return technician;
            }
        }
        return null;
    }

    @Override
    public List<Technician> findByName(String name) {
        List<Technician> technicianList = new ArrayList<Technician>();
        for (Technician technician : this.listOfTechnician) {
            if (technician.getName() == name) {
                technicianList.add(technician);
            }
        }
        return technicianList;
    }

    @Override
    public void update(Technician technician) throws Exception {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (this.listOfTechnician.get(i).getId() == technician.getId()) {
                this.listOfTechnician.set(i,technician);
                return;
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        for (int i = 0; i < this.listOfTechnician.size(); i++) {
            if (this.listOfTechnician.get(i).getId() == id) {
                this.listOfTechnician.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfTechnician = new ArrayList<>();
        this.nextID = 0;
    }
}
