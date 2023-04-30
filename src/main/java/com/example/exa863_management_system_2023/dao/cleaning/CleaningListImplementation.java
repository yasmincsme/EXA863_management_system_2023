package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class CleaningListImplementation implements CleaningDAO {

    private List<Cleaning> listOfCleanings;
    private String nextID;

    public CleaningListImplementation() {
        this.listOfCleanings = new ArrayList<Cleaning>();
        this.nextID = Generator.generateID();
    }

    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setID(this.nextID);
        this.nextID = Generator.generateID();
        this.listOfCleanings.add(cleaning);
        return cleaning;
    }

    @Override
    public List<Cleaning> findMany() {
        List<Cleaning> cleaningList = new ArrayList<Cleaning>();
        for (Cleaning cleaning : this.listOfCleanings) {
            cleaningList.add(cleaning);
        }
        return cleaningList;
    }

    @Override
    public Cleaning findByID(String id) {
        for (Cleaning cleaning : this.listOfCleanings) {
            if (cleaning.getID().equals(id)) {
                return cleaning;
            }
        }
        return null;
    }

    @Override
    public List<Cleaning> findByWorkOrderID(String workOrderID) {
        List<Cleaning> orderCleaningList = new ArrayList<>();
        for (Cleaning cleaning : this.listOfCleanings) {
            if (cleaning.getWorkOrderID().equals(workOrderID)) {
                orderCleaningList.add(cleaning);
            }
        }
        return orderCleaningList;
    }

    @Override
    public void update(Cleaning cleaning) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfCleanings.size(); i++) {
            if (this.listOfCleanings.get(i).getID().equals(cleaning.getID())) {
                this.listOfCleanings.set(i, cleaning);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.listOfCleanings.size(); i++) {
            if (this.listOfCleanings.get(i).getID().equals(id)) {
                this.listOfCleanings.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfCleanings = new ArrayList<Cleaning>();
        this.nextID = null;
    }
}
