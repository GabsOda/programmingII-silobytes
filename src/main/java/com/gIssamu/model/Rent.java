package com.gIssamu.model;

import java.io.Serializable;
import java.util.Date;

public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double quantity; 
    private Date time;

    private Producer producer;
    private Silo silo; 

    public Rent(Double quantity, Date time, Producer producer, Silo silo) {
        this.quantity = quantity;
        this.time = time;
        this.producer = producer;
        this.silo = silo; 
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Silo getSilo() {
        return silo;
    }

    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    @Override
    public String toString(){
        return ""+ producer + " - "+quantity; 
    }
}
