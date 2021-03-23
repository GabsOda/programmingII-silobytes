package com.gIssamu.model;

import java.io.Serializable;
import java.util.Date;

import com.gIssamu.util.PaymentConfirmation;

public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double quantity; 
    private Date date;

    private Producer producer;
    private Silo silo; 
    private PaymentConfirmation paymentConfirmation; 

    public Rent(Double quantity, Date date, Producer producer, Silo silo) {
        this.quantity = quantity;
        this.date = date;
        this.producer = producer;
        this.silo = silo; 
        this.paymentConfirmation = null; 
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public PaymentConfirmation getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    @Override
    public String toString(){
        return ""+ producer + " - "+quantity; 
    }
}
