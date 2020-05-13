package com.petclinic.persistence.dao;

import com.petclinic.persistence.model.VetModel;

public class VetDao extends ModelDao<VetModel>{
    public VetDao() {
        super("veterinar.txt");
    }
}
