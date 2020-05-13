package com.petclinic.persistence.dao;

import com.petclinic.persistence.model.PetModel;

public class PetDao extends ModelDao<PetModel> {
    public PetDao() {
        super("pet.txt");
    }
}
