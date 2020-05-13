package com.petclinic.services;

import com.petclinic.persistence.dao.ConsultDao;
import com.petclinic.persistence.model.ConsultModel;
import com.petclinic.persistence.model.PetModel;
import com.petclinic.persistence.model.VetModel;

import java.util.List;

public class ConsultService {
    private ConsultDao consultDao = new ConsultDao();

    public List<ConsultModel> viewConsults(){
        return consultDao.getAll();
    }

    public void addConsult(VetModel vetModel, PetModel petModel,String date){
        ConsultModel consult = new ConsultModel();
        consult.setPet(petModel);
        consult.setVet(vetModel);
        consult.setDate(date);
        consultDao.add(consult);
    }

    public void updateDescription(ConsultModel consultModel,String description){
        consultModel.setDescription(description);
    }

    public ConsultModel findByID(Long id){
            return consultDao.findById(id).get();
    }
}
