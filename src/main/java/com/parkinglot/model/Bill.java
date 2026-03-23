package main.java.com.parkinglot.model;

// Stores final bill details
public class Bill {

    private String ticketId;
    private double amount;

    public Bill(String ticketId, double amount) {
        this.ticketId = ticketId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{ticketId=" + ticketId + ", amount=" + amount + "}";
    }
}