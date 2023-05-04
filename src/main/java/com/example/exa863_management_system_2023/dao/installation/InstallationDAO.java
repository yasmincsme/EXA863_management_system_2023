package com.example.exa863_management_system_2023.dao.installation;

import com.example.exa863_management_system_2023.dao.CRUD;
import com.example.exa863_management_system_2023.model.Installation;

import java.util.List;

public interface InstallationDAO extends CRUD<Installation, Exception> {

    /**
     * Percorre a lista e retorna os serviços do tipo "installation" que contém o ID da mesma ordem de serviço.
     * @param workOrderID ID da ordem de serviço
     * @return Lista com todos os serviços do tipo "installation" que pertencem a uma mesma ordem de serviço
     */
    public List<Installation> findByWorkOrderID(String workOrderID);

    /**
     * Percorre a lista e retorna o preço de todos os serviços do tipo "installation" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Preço de todos os serviços do tipo "installation" de uma ordem de serviço
     */
    public double getPriceByServices(String workOrderID);

    /**
     * Percorre a lista e retorna o custo de todos os serviços do tipo "installation" da ordem de serviço desejada.
     * @param workOrderID ID da ordem de serviço
     * @return Custo de todos os serviços do tipo "installation" de uma ordem de serviço
     */
    public double getCostByServices(String workOrderID);
}
