package com.example.exa863_management_system_2023.model;

import java.util.ArrayList;
import java.util.List;

public class Cleaning extends Service{

    private List<ComputerComponent> components;

    /**
     *
     * @param name Name of the Cleaning
     * @param description Description of the Cleaning
     * @param price Price of the Cleaning
     * @param cost Cost og the Cleaning
     */
    public Cleaning(String name, String description, long price, long cost) {
        super(name, description, price, cost);
        this.components = new ArrayList<>();
    }

    /**
     *
     * @return Return Cleaning's component list
     */
    public List<ComputerComponent> getComponents() {
        return components;
    }

    /**
     *
     * @param components New value to component list
     */
    public void setComponents(List<ComputerComponent> components) {
        this.components = components;
    }

    /**
     * Add a new component to the component list
     * @param component New component
     */
    public void addComponent(ComputerComponent component) {
        this.components.add(component);
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Cleaning object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Cleaning) {
            Cleaning cleaning = (Cleaning) object;
            if (this.getID().equals(cleaning.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return super.toString() + ", Service: Cleaning" + ", Components: " + this.components;
    }
}
