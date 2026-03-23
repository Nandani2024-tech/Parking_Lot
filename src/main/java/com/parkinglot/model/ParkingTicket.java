package main.java.com.parkinglot.model;

import java.time.LocalDateTime;
import java.util.UUID;

// Ticket generated when vehicle enters
public class ParkingTicket {

    private String ticketId;
    private Vehicle vehicle;
    private Slot slot;
    private LocalDateTime inTime;
    private int entryGateId;

    public ParkingTicket(Vehicle vehicle, Slot slot, LocalDateTime inTime, int entryGateId) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.slot = slot;
        this.inTime = inTime;
        this.entryGateId = entryGateId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Slot getSlot() {
        return slot;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }
}