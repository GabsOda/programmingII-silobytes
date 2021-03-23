package com.gIssamu.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Silo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public String name;
    public Double capacity;

    public Double capacityEmpty; 

    private ArrayList<Rent> rentList; 

    public Silo(){
    }

    public Silo(String name, Double capacity) {
        this.name = name;
        this.capacity = capacity;
        capacityEmpty = capacity; 
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

    public void addRentOnSilo(Rent rent){
        rentList.add(rent);
    }

    public ArrayList<Rent> getRentList(){
        return rentList;
    }

    public Double getCapacityEmpty() {
        return capacityEmpty;
    }

    public void setCapacityEmpty(Double capacityEmpty) {
        this.capacityEmpty = capacityEmpty;
    }

    public void calculateCapacityEmpty(Double capacity, Double capacityEmpty){
        capacityEmpty -= capacity; 
    }

    @Override
    public String toString(){
        return name; 
    }
}
