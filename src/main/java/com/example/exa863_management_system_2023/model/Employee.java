package com.example.exa863_management_system_2023.model;

public class Employee extends User {

    /**
     *
     * @param name Name of the Employee
     * @param email Email of the Employee
     * @param login Login of the Employee
     * @param password Password of the Employee
     */
    public Employee(String name, String email, String login, String password) {
        super(name, email, login, password);
    }

    /**
     *
     * @param object Receive a random object
     * @return Return true if the given object is equal to the current Employee object, or false if they are not the same
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Employee) {
            Employee employee = (Employee) object;
            if (this.getID().equals(employee.getID())) {
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
        return super.toString() + ", Role: Employee";
    }
}
