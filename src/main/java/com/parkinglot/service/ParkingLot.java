package main.java.com.parkinglot.service;

import main.java.com.parkinglot.enums.SlotType;
import main.java.com.parkinglot.model.Bill;
import main.java.com.parkinglot.model.EntryGate;
import main.java.com.parkinglot.model.Floor;
import main.java.com.parkinglot.model.ParkingTicket;
import main.java.com.parkinglot.model.Slot;
import main.java.com.parkinglot.model.Vehicle;
import main.java.com.parkinglot.util.DistanceMatrix;

import java.time.LocalDateTime;
import java.util.List;


public class ParkingLot {

    private List<Floor> floors;
    private SlotCheck slotCheck;
    private BillCalculation billCalculation;
    private DistanceMatrix distanceMatrix;

    private ParkingLot() {
    }

    public static ParkingLot initializeParkingLot(
            int numberOfFloors,
            List<Floor> floors,
            List<EntryGate> gates,
            DistanceMatrix matrix
    ) {

        ParkingLot parkingLot = new ParkingLot();

        parkingLot.floors = floors;
        parkingLot.distanceMatrix = matrix;

        // Internal services created here
        parkingLot.slotCheck = new SlotCheck(floors, matrix);
        parkingLot.billCalculation = new BillCalculation();

        return parkingLot;
    }

    public ParkingTicket generateParkingTicket(
            Vehicle vehicle,
            java.time.LocalDateTime inTime,
            SlotType requestedSlot,
            int entryGateId) {

        Slot slot = slotCheck.assignSlot(requestedSlot, entryGateId);
        slot.occupy();

        return new ParkingTicket(vehicle, slot, inTime, entryGateId);
    }

    public Bill generateBill(ParkingTicket ticket, java.time.LocalDateTime outTime) {

        Bill bill = billCalculation.calculateBill(ticket, outTime);
        ticket.getSlot().free();

        return bill;
    }

    public void showStatus() {
        slotCheck.printAvailableSlots();
    }
}