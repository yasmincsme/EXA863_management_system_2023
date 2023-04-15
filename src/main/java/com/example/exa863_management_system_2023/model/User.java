package com.example.exa863_management_system_2023.model;

public abstract class User extends Person {

    private String login;
    private String password;

    public User(String id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public User(String name) {
        super(name);
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
