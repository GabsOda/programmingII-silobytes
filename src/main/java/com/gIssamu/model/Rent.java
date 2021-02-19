package com.gIssamu.model;

import java.io.Serializable;

public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double quantity; 
    private Integer time;

    private Producer producer;

    public Rent(Double quantity, Integer time, Producer producer) {
        this.quantity = quantity;
        this.time = time;
        this.producer = producer;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

}
