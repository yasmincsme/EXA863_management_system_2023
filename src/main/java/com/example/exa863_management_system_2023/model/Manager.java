package com.example.exa863_management_system_2023.model;

import java.io.Serializable;

public class Manager implements Serializable {

    private String id;
    private final String type = "MANAGER";
    private String name;
    private String email;
    private String login;
    private String password;

    /**
     * Cria um novo objeto do tipo "manager"
     * @param name Nome do gerente
     * @param email Email do gerente
     * @param login Login do gerente
     * @param password Senha do gerente
     */
    public Manager(String name, String email, String login, String password) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    /**
     * Retorna o ID do objeto.
     * @return ID do objeto
     */
    public String getID() {
        return id;
    }

    /**
     * Atribui um novo valor para o ID.
     * @param id Novo valor para o ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Retorna o nome da entidade referida.
     * @return Nome da entidade referida
     */
    public String getName() {
        return name;
    }

    /**
     * Atribui um novo nome à entidade referida.
     * @param name Novo nome para a entidade referida
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o email da entidade referida.
     * @return Email da entidade referida
     */
    public String getEmail() {
        return email;
    }

    /**
     * Atribui um novo email à entidade referida.
     * @param email Novo email para a entidade referida
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o login da entidade referida.
     * @return Login da entidade referida
     */
    public String getLogin() {
        return login;
    }

    /**
     * Atribui um novo login à entidade referida.
     * @param login Novo login para a entidade referida
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retorna a senha da entidade referida.
     * @return Senha da entidade referida
     */
    public String getPassword() {
        return password;
    }

    /**
     * Atribui uma nova senha à entidade referida.
     * @param password Nova senha para a entidade referida
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Compara dois objetos do tipo "employee" a partir do ID
     * @param object Objeto do tipo "employee"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if(object instanceof Manager) {
            Manager manager = (Manager) object;
            if (this.getID().equals(manager.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna uma representação em String do objeto.
     * @return Representação em String do objeto
     */
    @Override
    public String toString() {
        return "Role: " + this.type + ", ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email + ", Login: " + this.login + ", Password: " + this.password;
    }
}
