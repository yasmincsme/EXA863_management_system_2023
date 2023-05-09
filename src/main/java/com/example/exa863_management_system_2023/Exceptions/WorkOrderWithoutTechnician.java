package com.example.exa863_management_system_2023.Exceptions;

public class WorkOrderWithoutTechnician extends Exception{

    /**
     * Uma determinada mensagem é lançada quando uma ordem de serviço é finalizada sem um técnico
     * @param message Mensagem de erro
     */
    public WorkOrderWithoutTechnician(String message) {
        super(message);
    }
}
