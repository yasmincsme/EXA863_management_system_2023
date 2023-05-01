package com.example.exa863_management_system_2023.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.List;

public class FileManager<T> {

    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    public static <T> void writeListToFile(List<T> list, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            outputStream.writeObject(list);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> List<T> readListFromFile(String fileName) {
        List<T> list = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            list = (List<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        return list;
    }
}
