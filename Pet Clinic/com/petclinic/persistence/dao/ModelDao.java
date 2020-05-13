package com.petclinic.persistence.dao;

import com.petclinic.persistence.model.Model;

import java.util.List;
import java.util.Optional;

public abstract class ModelDao<T extends Model> implements Dao<T> {

    private String fileName;
    private FileScanner<T> fileScanner = new FileScanner<>();

    public ModelDao(String filename){
        this.fileName = filename;

    }

    @Override
    public void add(T obiectGeneric) {
        List<T> obiecte = fileScanner.read(fileName);
        obiecte.add(obiectGeneric);
        fileScanner.write(obiecte, fileName);
    }

    @Override
    public void remove(long id) {
        List<T> obiecte = fileScanner.read(fileName);
        obiecte.removeIf(t -> t.getCod() == id);
        fileScanner.write(obiecte, fileName);
    }

    @Override
    public Optional<T> findById(long id) {
        List<T> obiecte = fileScanner.read(fileName);
        return obiecte.stream().filter(obiect -> obiect.getCod()
                == id).findFirst();
    }

    @Override
    public List<T> getAll() {
        return fileScanner.read(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public FileScanner<T> getFileScanner() {
        return fileScanner;
    }

}
