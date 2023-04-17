package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CleaningListImplementation implements CleaningDAO {

    private List<Cleaning> listOfCleaning;
    private String nextID;

    public CleaningListImplementation() {
        this.listOfCleaning = new ArrayList<Cleaning>();
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
    }

    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setID(this.nextID);
        UUID uuid = UUID.randomUUID();
        this.nextID = uuid.toString();
        this.listOfCleaning.add(cleaning);
        return cleaning;
    }

    @Override
    public List<Cleaning> findMany() {
        List<Cleaning> cleaningList = new ArrayList<Cleaning>();
        for (Cleaning cleaning : this.listOfCleaning) {
            cleaningList.add(cleaning);
        }
        return cleaningList;
    }

    @Override
    public Cleaning findByID(String id) {
        for (Cleaning cleaning : this.listOfCleaning) {
            if (cleaning.getID().equals(id)) {
                return cleaning;
            }
        }
        return null;
    }

    @Override
    public void update(Cleaning cleaning) throws Exception {
        for (int i = 0; i < this.listOfCleaning.size(); i++) {
            if (this.listOfCleaning.get(i).getID().equals(cleaning.getID())) {
                this.listOfCleaning.set(i, cleaning);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < this.listOfCleaning.size(); i++) {
            if (this.listOfCleaning.get(i).getID().equals(id)) {
                this.listOfCleaning.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfCleaning = new ArrayList<Cleaning>();
        this.nextID = null;
    }
}
