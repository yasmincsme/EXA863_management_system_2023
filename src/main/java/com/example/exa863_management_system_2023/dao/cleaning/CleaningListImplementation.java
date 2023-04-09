package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.model.Cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningListImplementation implements CleaningDAO {

    private List<Cleaning> listOfCleaning;
    private int nextID;

    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setId(this.nextID);
        this.nextID++;
        this.listOfCleaning.add(cleaning);
        return cleaning;
    }

    @Override
    public List<Cleaning> findMany() {
        List<Cleaning> cleaningList = new ArrayList<Cleaning>();
        for (Object cleaning : this.listOfCleaning) {
            cleaningList.add((Cleaning) cleaning);
        }
        return cleaningList;
    }

    @Override
    public Cleaning findByID(int id) {
        for (Cleaning cleaning : this.listOfCleaning) {
            if (cleaning.getId() == id) {
                return cleaning;
            }
        }
        return null;
    }

    @Override
    public void update(Cleaning cleaning) throws Exception {
        for (int i = 0; i < this.listOfCleaning.size(); i++) {
            if (this.listOfCleaning.get(i).getId() == cleaning.getId()) {
                this.listOfCleaning.set(i, cleaning);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.listOfCleaning.size(); i++) {
            if (this.listOfCleaning.get(i).getId() == id) {
                this.listOfCleaning.remove(i);
            }
        }
    }

    @Override
    public void deleteMany() {
        this.listOfCleaning = new ArrayList<Cleaning>();
        this.nextID = 0;
    }
}
