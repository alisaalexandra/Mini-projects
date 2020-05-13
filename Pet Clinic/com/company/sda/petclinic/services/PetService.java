package com.company.sda.petclinic.services;

import com.company.sda.petclinic.persistence.dao.PetDao;
import com.company.sda.petclinic.persistence.model.PetModel;

import java.util.List;

public class PetService {
    private PetDao petDao = new PetDao();

    public List<PetModel> viewPets(){
        return petDao.getAll();
    }

    public void addPet(PetModel petModel) {
        petDao.add(petModel);
    }

    public void deletePet(long id){
        if(petDao.findById(id).isPresent()) {
            petDao.remove(id);
        }else
            System.out.println("Wrong ID!");
    }

    public PetModel findByID(long id){
        return petDao.findById(id).get();
    }

    public void updatePet(PetModel petModel) {
        petDao.remove(petModel.getCod());
        petDao.add(petModel);
    }

}
