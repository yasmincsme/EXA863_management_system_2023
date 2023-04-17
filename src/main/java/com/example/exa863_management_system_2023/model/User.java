package com.example.exa863_management_system_2023.model;

public abstract class User extends Person {

    private String login;
    private String password;

    /**
     *
     * @param name Name of the User
     * @param email Email of the User
     * @param login Login of the User
     * @param password Password of the User
     */
    public User(String name, String email, String login, String password) {
        super(name, email);
        this.login = login;
        this.password = password;
    }

    /**
     *
     * @return Return the User's login
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login New value to login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return Return the User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password New value to password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return Return a short formatted description of the object
     */
    @Override
    public String toString() {
        return super.toString() + ", Login: " + this.login + ", Password: " + this.password;
    }
}
