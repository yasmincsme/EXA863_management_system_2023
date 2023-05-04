package com.example.exa863_management_system_2023.dao.building;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Building;

import java.util.List;

public interface BuildingDAO extends CRUD<Building, Exception> {

    /**
     * Percorre a lista e retorna os serviços do tipo "building" que contém o ID da mesma ordem de serviço.
     * @param workOrderID ID da ordem de serviço
     * @return Lista com todos os serviços do tipo "building" que pertencem a uma mesma ordem de serviço
     */
    public List<Building> findByWorkOrderID(String workOrderID);

    /**
     * Percorre a lista e retorna o preço de todos os serviços do tipo "building" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Preço de todos os serviços do tipo "building" de uma ordem de serviço
     */
    public double getPriceByServices(String workOrderID);

    /**
     * Percorre a lista e retorna o custo de todos os serviços do tipo "building" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Custo de todos os serviços do tipo "building" de uma ordem de serviço
     */
    public double getCostByServices(String workOrderID);
}
