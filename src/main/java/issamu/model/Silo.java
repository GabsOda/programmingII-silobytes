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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
        result = prime * result + ((capacityEmpty == null) ? 0 : capacityEmpty.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Silo other = (Silo) obj;
        if (capacity == null) {
            if (other.capacity != null)
                return false;
        } else if (!capacity.equals(other.capacity))
            return false;
        if (capacityEmpty == null) {
            if (other.capacityEmpty != null)
                return false;
        } else if (!capacityEmpty.equals(other.capacityEmpty))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
}
