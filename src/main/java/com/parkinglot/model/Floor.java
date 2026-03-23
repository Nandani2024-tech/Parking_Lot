package main.java.com.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

// Each floor contains multiple slots
public class Floor {

    private int floorId;
    private List<Slot> slots;

    public Floor(int floorId) {
        this.floorId = floorId;
        this.slots = new ArrayList<>();
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getSlots() {
        return slots;
    }
}