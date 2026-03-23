package main.java.com.parkinglot.model;

import main.java.com.parkinglot.enums.SlotType;

// Represents one parking slot
public class Slot {

    private int slotId;
    private SlotType slotType;
    private boolean isOccupied;

    public Slot(int slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public int getSlotId() {
        return slotId;
    }

    // Mark slot as occupied
    public void occupy() {
        isOccupied = true;
    }

    // Free slot when vehicle leaves
    public void free() {
        isOccupied = false;
    }
}