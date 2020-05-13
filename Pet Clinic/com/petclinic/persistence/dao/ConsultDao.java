package com.petclinic.persistence.dao;

import com.petclinic.persistence.model.ConsultModel;

public class ConsultDao extends ModelDao<ConsultModel> {
    public ConsultDao() {
        super("consult.txt");
    }
}
