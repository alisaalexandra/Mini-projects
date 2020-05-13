package com.petclinic.persistence.model;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private long cod;

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }
}
