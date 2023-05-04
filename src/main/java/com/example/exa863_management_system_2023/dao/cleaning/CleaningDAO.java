package com.example.exa863_management_system_2023.dao.cleaning;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Cleaning;

import java.util.List;

public interface CleaningDAO extends CRUD<Cleaning, Exception> {

    /**
     * Percorre a lista e retorna os serviços do tipo "cleaning" que contém o ID da mesma ordem de serviço.
     * @param workOrderID ID da ordem de serviço
     * @return Lista com todos os serviços do tipo "cleaning" que pertencem a uma mesma ordem de serviço
     */
    public List<Cleaning> findByWorkOrderID(String workOrderID);

    /**
     * Percorre a lista e retorna o preço de todos os serviços do tipo "cleaning" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Preço de todos os serviços do tipo "cleaning" de uma ordem de serviço
     */
    public double getPriceByServices(String workOrderID);

    /**
     * Percorre a lista e retorna o custo de todos os serviços do tipo "cleaning" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Custo de todos os serviços do tipo "cleaning" de uma ordem de serviço
     */
    public double getCostByServices(String workOrderID);
}
