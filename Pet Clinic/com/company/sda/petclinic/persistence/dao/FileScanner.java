package com.company.sda.petclinic.persistence.dao;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileScanner<T> {


    public void write(List<T> anuntList, String numeFisier) {
        File fie = new File(numeFisier);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fie);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(anuntList);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erroare!");
        }
    }

    public List<T> read(String numeFisier) {
        File fie = new File(numeFisier);
        if (!fie.exists()) {
            return new ArrayList<>();
        }
        List<T> anunturiDinFisier = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fie);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Fiserul nu exista inca!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return anunturiDinFisier;
    }
}
