package issamu.model;

import java.io.Serializable;

public class Silo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String name;
    private Double capacity;

    private Double capacityEmpty; 

    public Silo(){
    }

    public Silo(String name, Double capacity, Double emptyCapacity) {
        this.name = name;
        this.capacity = capacity;
        this.capacityEmpty = emptyCapacity; 
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
