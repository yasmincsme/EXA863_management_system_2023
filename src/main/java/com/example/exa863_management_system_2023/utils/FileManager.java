package com.example.exa863_management_system_2023.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager<T> {

    private String fileName;

    public FileManager(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                writeListToFile(new ArrayList<>(), fileName);
            } catch (IOException exception) {
                throw new RuntimeException("Unable to create a new file", exception);
            }
        } else if (!file.isFile()) {
            throw new IllegalArgumentException("The provided file name is not a valid file path");
        }
    }
    public static <T> void writeListToFile(List<T> list, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            outputStream.write(new byte[0]);
            outputStream.writeObject(list);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> List<T> readListFromFile(String fileName) {
        List<T> list = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            list = (ArrayList<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
        return list;
    }
}
