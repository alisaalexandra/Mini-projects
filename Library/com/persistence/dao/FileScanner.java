package com.persistence.dao;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileScanner<T> {


    public void write(List<T> list, String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Eroare!");
        }
    }

    public List<T> read(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Fiserul nu exista inca!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
