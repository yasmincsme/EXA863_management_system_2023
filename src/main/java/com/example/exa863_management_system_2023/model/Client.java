package com.example.exa863_management_system_2023.model;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {

    private String id;
    private final String type = "CLIENT";
    private String name;
    private String email;
    private String address;
    private String phone;


    /**
     * Cria um novo objeto do tipo "client".
     * @param name Nome do cliente
     * @param email Email do cliente
     * @param address Endereço do cliente
     * @param phone Endereço do telefone
     */
    public Client(String name, String email, String address, String phone) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
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
     * Retorna o endereço da entidade referida.
     * @return Endereço da entidade referida
     */
    public String getAddress() {
        return address;
    }

    /**
     * Atribui um novo endereço à entidade referida.
     * @param address Novo endereço para a entidade referida
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retorna o telefone da entidade referida.
     * @return Telefone da entidade referida
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Atribui um novo telefone à entidade referida.
     * @param phone Novo telefone para a entidade referida
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Compara dois objetos do tipo "client" a partir do ID
     * @param object Objeto do tipo "client"
     * @return True se o objeto informado tem o mesmo ID do objeto comparado, False caso contrário.
     */
    @Override
    public boolean equals(Object object) {
        if(object instanceof Client) {
            Client client = (Client) object;
            if (this.getID().equals(client.getID())) {
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
        return "Role: " + this.type + ", ID: " + this.id + ", Name: " + this.name + ", Email: " + this.email + ", Address: " + this.address + ", Phone: " + this.phone;
    }
}
