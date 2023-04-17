package com.example.exa863_management_system_2023.model;

public class Technician extends User {

    /**
     *
     * @param name Name of the Technician
     * @param email Email of the Technician
     * @param login Login of the Technician
     * @param password Password of the Technician
     */
    public Technician(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Technician object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Technician) {
            Technician technician = (Technician) object;
            if (this.getID().equals(technician.getID())) {
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
        return super.toString() + ", Role: Technician";
    }
}
