package com.persistence.model;

import java.io.Serializable;

public abstract class Model implements Serializable {

    private long code;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
