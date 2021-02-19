package com.gIssamu.model;

import java.io.Serializable;

public class Silo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public Integer number;
    public Double capacity;

    public Silo(Integer number, Double capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
}
