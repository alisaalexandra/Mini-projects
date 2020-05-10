package com.persistence.dao;

import com.exceptions.CategoryNotFoundException;
import com.persistence.model.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class ModelDao<T extends Model> implements Dao<T>, Serializable {
    private String fileName;
    private ObjectFileScanner<T> fileReader = new ObjectFileScanner<>();

    public ModelDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<T> getAll() {
        return fileReader.readFromFile(fileName);
    }

    @Override
    public Optional<T> findById(String id) throws CategoryNotFoundException {
       if(validate(id)) {
           return fileReader.readFromFile(fileName).stream().filter(parameter -> parameter.getId().equalsIgnoreCase(id)).findFirst();
       }else
           throw new CategoryNotFoundException();
    }

    @Override
    public void remove(String id) {
        List<T> list = fileReader.readFromFile(fileName);
        if (Integer.parseInt(id) == list.size()) {
            list.removeIf(parameter -> parameter.getId().equalsIgnoreCase(id));
            fileReader.writeToFile(list, fileName);
        } else if (Integer.parseInt(id) < list.size()) {
            list.removeIf(parameter -> parameter.getId().equalsIgnoreCase(id));
            list.stream().forEach(parameter -> {
                if (Integer.parseInt(parameter.getId()) >= Integer.parseInt(id)) {
                    parameter.setId(Integer.toString(Integer.parseInt(parameter.getId()) - 1));
                }
            });
        }
        fileReader.writeToFile(list, fileName);
    }

    @Override
    public void add(T t) {
        List<T> list = fileReader.readFromFile(fileName);
        list.add(t);
        fileReader.writeToFile(list, fileName);
    }

    public boolean validate(String id) {
        List<T> list = fileReader.readFromFile(fileName);
        return list.stream().anyMatch(parameter -> parameter.getId().equalsIgnoreCase(id));
    }
}
