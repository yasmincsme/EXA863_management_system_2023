package com.example.exa863_management_system_2023.utils;

import java.util.UUID;

public class Generator() {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
