package com.gIssamu.model;

import java.io.Serializable;

public class Silo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public String name;
    public Double capacity;

    public Silo(){
    }

    public Silo(String name, Double capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString(){
        return name; 
    }
}
