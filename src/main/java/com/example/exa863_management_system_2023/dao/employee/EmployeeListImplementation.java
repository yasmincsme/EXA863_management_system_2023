package com.example.exa863_management_system_2023.dao.employee;

import com.example.exa863_management_system_2023.exceptions.ObjectNotFoundException;
import com.example.exa863_management_system_2023.model.Employee;
import com.example.exa863_management_system_2023.utils.Generator;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListImplementation implements EmployeeDAO {

    private List<Employee> listOfEmployees;

    public EmployeeListImplementation() {
        this.listOfEmployees = new ArrayList<Employee>();
    }

    /**
     * Cria um novo objeto do tipo especificado.
     * @param employee Objeto que será adicionado ao sistema
     * @return Objeto recém criado
     */
    @Override
    public Employee create(Employee employee) {
        employee.setID(Generator.generateID());
        this.listOfEmployees.add(employee);
        return employee;
    }

    /**
     * Retorna todos os objetos do tipo especificado registrados no sistema.
     * @return Lista com todos os objetos do tipo especificado registrados no sistema
     */
    @Override
    public List<Employee> findMany() {
        return listOfEmployees;
    }

    /**
     * Percorre a lista e retorna o objeto conforme o ID informado.
     * @param id ID do objeto que se deseja encontrar
     * @return Objeto desejado
     */
    @Override
    public Employee findByID(String id) {
        for (Employee employee : this.listOfEmployees) {
            if (employee.getID().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Percorre a lista e retorna o objeto Funcionário correspondente ao login informado.
     * @param login Login do Funcionário que se deseja encontrar
     * @return Lista com os funcionários que possuem o login informado
     */
    @Override
    public List<Employee> findByLogin(String login) {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (Employee employee : this.listOfEmployees) {
            if (employee.getLogin().equals(login)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    /**
     * Percorre a lista e atualiza o objeto informado.
     * @param employee Objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void update(Employee employee) throws ObjectNotFoundException {
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (this.listOfEmployees.get(i).getID().equals(employee.getID())) {
                this.listOfEmployees.set(i, employee);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed employee is not registered in the system");
    }

    /**
     * Percorre a lista e deleta o objeto informado.
     * @param id ID do objeto que será atualizado
     * @throws ObjectNotFoundException
     */
    @Override
    public void delete(String id) throws ObjectNotFoundException{
        for (int i = 0; i < this.listOfEmployees.size(); i++) {
            if (this.listOfEmployees.get(i).getID().equals(id)) {
                this.listOfEmployees.remove(i);
                return;
            }
        }
        throw new ObjectNotFoundException("The informed employee is not registered in the system");
    }

    /**
     * Deleta todos os elementos da lista
     */
    @Override
    public void deleteMany() {
        this.listOfEmployees = new ArrayList<Employee>();
    }
}
