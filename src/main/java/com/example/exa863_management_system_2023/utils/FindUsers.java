package com.example.exa863_management_system_2023.utils;

import com.example.exa863_management_system_2023.dao.DAO;

import java.util.ArrayList;

public class FindUsers {

    public static ArrayList<Object> findAllUsers() {
        ArrayList<Object> usersList = new ArrayList<>();

        usersList.addAll(DAO.getEmployee().findMany());
        usersList.addAll(DAO.getManager().findMany());
        usersList.addAll(DAO.getTechnician().findMany());

        return usersList;
    }
}
