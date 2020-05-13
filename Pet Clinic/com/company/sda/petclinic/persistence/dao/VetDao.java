package com.company.sda.petclinic.persistence.dao;

import com.company.sda.petclinic.persistence.model.VetModel;

public class VetDao extends ModelDao<VetModel>{
    public VetDao() {
        super("veterinar.txt");
    }
}
