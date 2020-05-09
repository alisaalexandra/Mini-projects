package com.persistence.model;

import java.io.Serializable;

public class Model implements Serializable {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
