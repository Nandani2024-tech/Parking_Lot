package main.java.com.parkinglot.service;

import main.java.com.parkinglot.enums.SlotType;
import main.java.com.parkinglot.model.Bill;
import main.java.com.parkinglot.model.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

// Only responsible for calculating bill
public class BillCalculation {

    public Bill calculateBill(ParkingTicket ticket, LocalDateTime outTime) {

        long hours = Duration.between(ticket.getInTime(), outTime).toHours();
        if (hours == 0) hours = 1;

        double rate = getRate(ticket.getSlot().getSlotType());

        double amount = hours * rate;

        return new Bill(ticket.getTicketId(), amount);
    }

    private double getRate(SlotType type) {
        switch (type) {
            case SMALL: return 10;
            case MEDIUM: return 20;
            case LARGE: return 30;
            default: return 0;
        }
    }
}