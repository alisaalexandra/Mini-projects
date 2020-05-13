package com.company.sda.petclinic.persistence.dao;

import com.company.sda.petclinic.persistence.model.PetModel;

public class PetDao extends ModelDao<PetModel> {
    public PetDao() {
        super("pet.txt");
    }
}
