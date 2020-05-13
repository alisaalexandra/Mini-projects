package com.company.sda.petclinic.persistence.dao;

import com.company.sda.petclinic.persistence.model.ConsultModel;

public class ConsultDao extends ModelDao<ConsultModel> {
    public ConsultDao() {
        super("consult.txt");
    }
}
