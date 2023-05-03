package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.Exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Building;
import com.example.exa863_management_system_2023.model.Cleaning;
import com.example.exa863_management_system_2023.model.Manager;
import com.example.exa863_management_system_2023.utils.FileManager;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class CleaningArchiveImplementation implements CleaningDAO{
    private List<Cleaning> listOfCleanings;
    private FileManager<String> fileManager;

    public CleaningArchiveImplementation() {
        fileManager = new FileManager<>("cleanings.dat");
        listOfCleanings = FileManager.readListFromFile("cleanings.dat");
    }

    @Override
    public Cleaning create(Cleaning cleaning) {
        cleaning.setID(Generator.generateID());
        listOfCleanings.add(cleaning);
        FileManager.writeListToFile(listOfCleanings, "cleanings.dat");
        return cleaning;
    }

    @Override
    public List<Cleaning> findMany() {
        return FileManager.readListFromFile("cleanings.dat");
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
                FileManager.writeListToFile(listOfCleanings, "cleanings.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void delete(String id) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfCleanings.size(); i++) {
            if (listOfCleanings.get(i).getID().equals(id)) {
                listOfCleanings.remove(i);
                FileManager.writeListToFile(listOfCleanings, "cleanings.dat");
                return;
            }
        }
        throw new ObjectNotFoundException("The informed service is not registered in the system");
    }

    @Override
    public void deleteMany() {
        listOfCleanings = new ArrayList<>();
        FileManager.writeListToFile(listOfCleanings, "cleanings.dat");
    }

    @Override
    public double getPriceByServices(String workOrderID) {
        double servicesPrice = 0;
        for (Cleaning cleaning : this.listOfCleanings) {
            if(cleaning.getWorkOrderID().equals(workOrderID)) {
                servicesPrice += cleaning.getPrice();
            }
        }
        return servicesPrice;
    }

    @Override
    public double getCostByServices(String workOrderID) {
        double servicesCost = 0;
        for (Cleaning cleaning : this.listOfCleanings) {
            if(cleaning.getWorkOrderID().equals(workOrderID)) {
                servicesCost += cleaning.getCost();
            }
        }
        return servicesCost;
    }
}
