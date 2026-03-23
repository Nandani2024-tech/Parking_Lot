package main.java.com.parkinglot.service;

import main.java.com.parkinglot.enums.SlotType;
import main.java.com.parkinglot.model.Floor;
import main.java.com.parkinglot.model.Slot;
import main.java.com.parkinglot.util.DistanceMatrix;

import java.util.List;

// Responsible for finding nearest available slot
public class SlotCheck {

    private List<Floor> floors;
    private DistanceMatrix distanceMatrix;

    public SlotCheck(List<Floor> floors, DistanceMatrix distanceMatrix) {
        this.floors = floors;
        this.distanceMatrix = distanceMatrix;
    }

    public Slot assignSlot(SlotType type, int gateId) {

        Slot bestSlot = null;
        int minDistance = Integer.MAX_VALUE;

        for (Floor floor : floors) {
            for (Slot slot : floor.getSlots()) {

                if (!slot.isOccupied() && slot.getSlotType() == type) {

                    int distance = distanceMatrix.getDistance(gateId, slot.getSlotId());

                    if (distance < minDistance) {
                        minDistance = distance;
                        bestSlot = slot;
                    }
                }
            }
        }

        if (bestSlot == null) {
            throw new RuntimeException("No slot available");
        }

        return bestSlot;
    }

    public void printAvailableSlots() {
        for (Floor floor : floors) {
            for (Slot slot : floor.getSlots()) {
                if (!slot.isOccupied()) {
                    System.out.println("Available Slot: " + slot.getSlotId());
                }
            }
        }
    }
}