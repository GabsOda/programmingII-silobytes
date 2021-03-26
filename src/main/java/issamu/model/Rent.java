package issamu.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import issamu.util.PaymentConfirmation;

public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double quantity; 
    private LocalDate date;

    private Producer producer;
    private Silo silo; 
    private PaymentConfirmation paymentConfirmation; 

    public Rent(Double quantity, LocalDate date, Producer producer, Silo silo) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        StringBuilder sb = new StringBuilder();

        sb.append(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        sb.append(" - ");
        sb.append(silo);
        sb.append(" - ");
        sb.append(quantity.toString());
        sb.append(" - ");
        sb.append(producer);
        
        return sb.toString(); 
    }
}
