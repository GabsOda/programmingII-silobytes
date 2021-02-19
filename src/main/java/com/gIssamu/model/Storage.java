package com.gIssamu.model;

import java.io.Serializable;
import java.util.Date;

public class Storage implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Date deliveryDate; 
    private Double quantity;

    // private Rent rent;
    // private Silo silo; 

    public Storage(Date deliveryDate, Double quantity) {
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
