package com.persistence.dao;

import com.persistence.model.Model;

import java.util.List;
import java.util.Optional;

public abstract class ModelDao<T extends Model> implements Dao<T> {

    private String fileName;
    private FileScanner<T> fileScanner = new FileScanner<>();

    public ModelDao(String filename){
        this.fileName = filename;

    }

    //@Override
    public void add(T t) {
        List<T> list = fileScanner.read(fileName);
        list.add(t);
        fileScanner.write(list, fileName);
    }

    @Override
    public void remove(long id) {
        List<T> list = fileScanner.read(fileName);
        list.removeIf(t -> t.getCode() == id);
        fileScanner.write(list, fileName);
    }

    @Override
    public Optional<T> findById(long id) {
        List<T> list = fileScanner.read(fileName);
        return list.stream().filter(parameter -> parameter.getCode()
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
