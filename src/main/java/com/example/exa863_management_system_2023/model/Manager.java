package com.example.exa863_management_system_2023.model;

public class Manager extends User{

    /**
     *
     * @param name Name of the Manager
     * @param email Email of the Manager
     * @param login Login of the Manager
     * @param password Password of the Manager
     */
    public Manager(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Manager object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Manager) {
            Manager manager = (Manager) object;
            if (this.getID().equals(manager.getID())) {
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
        return super.toString() + ", Role: Manager";
    }
}
