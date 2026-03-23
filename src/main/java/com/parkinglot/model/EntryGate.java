package main.java.com.parkinglot.model;
// Represents an entry gate
public class EntryGate {

    private int gateId;
    private int floorId;

    public EntryGate(int gateId, int floorId) {
        this.gateId = gateId;
        this.floorId = floorId;
    }

    public int getGateId() {
        return gateId;
    }
}