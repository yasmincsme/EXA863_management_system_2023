package com.example.exa863_management_system_2023.Exceptions;

public class InvalidSatisfactionScore extends Exception {

    /**
     * Uma determinada mensagem é lançada quando um valor inválido é informado
     * @param message Mensagem de erro
     */
    public InvalidSatisfactionScore(String message) {
        super(message);
    }
}
