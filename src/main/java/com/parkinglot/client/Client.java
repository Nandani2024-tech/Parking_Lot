package main.java.com.parkinglot.client;

import main.java.com.parkinglot.config.ParkingLotConfig;
import main.java.com.parkinglot.enums.SlotType;
import main.java.com.parkinglot.enums.VehicleType;
import main.java.com.parkinglot.model.Vehicle;
import main.java.com.parkinglot.model.ParkingTicket;
import main.java.com.parkinglot.model.Bill;
import main.java.com.parkinglot.service.ParkingLot;

import java.time.LocalDateTime;

public class Client {

    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.initializeParkingLot(
                2,                 // number of floors
                ParkingLotConfig.sampleSlotConfig(),
                ParkingLotConfig.sampleGates(),
                ParkingLotConfig.sampleDistanceMatrix()
        );

        Vehicle vehicle = new Vehicle(
                "KA01AB1234",
                "Red",
                "Honda",
                VehicleType.CAR
        );

        ParkingTicket ticket = parkingLot.generateParkingTicket(
                vehicle,
                LocalDateTime.now(),
                SlotType.MEDIUM,
                1
        );

        System.out.println("Ticket Generated: " + ticket.getTicketId());

        parkingLot.showStatus();

        Bill bill = parkingLot.generateBill(
                ticket,
                LocalDateTime.now().plusHours(2)
        );

        System.out.println(bill);
    }
}