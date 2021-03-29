package issamu.model;

import java.io.Serializable;

import issamu.util.PaymentConfirmation;

public class Withdrawn implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Rent rent; 
    private Double totalCost; 
    private PaymentConfirmation paid; 

    public Withdrawn(Rent rent, Double totalCost,  PaymentConfirmation paid){
        this.rent = rent; 
        this.totalCost = totalCost; 
        this.paid = paid; 
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Double getTotalCost(){
        return totalCost; 
    }

    public void setTotalCost(Double totalCost){
        this.totalCost = totalCost; 
    }

    public PaymentConfirmation getPaid() {
        return paid;
    }

    public void setPaid(PaymentConfirmation paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return rent + " => " + paid;
    }

    
}
