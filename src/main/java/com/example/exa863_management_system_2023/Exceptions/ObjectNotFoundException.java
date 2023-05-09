package com.example.exa863_management_system_2023.Exceptions;

public class ObjectNotFoundException extends Exception{

    /**
     * Uma determinada mensagem é lançada quando o objeto não é encontrado
     * @param message Mensagem de erro
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
