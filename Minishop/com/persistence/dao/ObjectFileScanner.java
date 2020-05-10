package com.persistence.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileScanner<T> {
    List<T> list = new ArrayList<>();

    public void writeToFile(List<T> list,String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> readFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }
}
