package com.petclinic.services;

import com.petclinic.persistence.dao.VetDao;
import com.petclinic.persistence.model.VetModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VetService {

    private VetDao vetDao = new VetDao();

    public void addVeterniar(VetModel vetModel){
        vetDao.add(vetModel);
    }

    public List<VetModel> getAllVeterniars(){

        List<VetModel> vetModels = vetDao.getAll();
        return vetModels.stream()
                .sorted(Comparator.comparing(vetModel -> vetModel.getLastName()))
                .collect(Collectors.toList());
    }

    public VetModel findByID(Long id){
        return vetDao.findById(id).get();
    }
}
