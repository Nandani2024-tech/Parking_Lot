package main.java.com.parkinglot.config;

import main.java.com.parkinglot.enums.SlotType;
import main.java.com.parkinglot.model.EntryGate;
import main.java.com.parkinglot.model.Floor;
import main.java.com.parkinglot.model.Slot;
import main.java.com.parkinglot.util.DistanceMatrix;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotConfig {

    public static List<Floor> sampleSlotConfig() {

        Floor floor1 = new Floor(1);
        floor1.addSlot(new Slot(1, SlotType.SMALL));
        floor1.addSlot(new Slot(2, SlotType.MEDIUM));
        floor1.addSlot(new Slot(3, SlotType.LARGE));

        Floor floor2 = new Floor(2);
        floor2.addSlot(new Slot(4, SlotType.SMALL));
        floor2.addSlot(new Slot(5, SlotType.MEDIUM));
        floor2.addSlot(new Slot(6, SlotType.LARGE));

        List<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);

        return floors;
    }

    public static List<EntryGate> sampleGates() {

        List<EntryGate> gates = new ArrayList<>();
        gates.add(new EntryGate(1, 1));
        gates.add(new EntryGate(2, 2));

        return gates;
    }

    public static DistanceMatrix sampleDistanceMatrix() {

        DistanceMatrix matrix = new DistanceMatrix();

        matrix.setDistance(1, 1, 5);
        matrix.setDistance(1, 2, 2);
        matrix.setDistance(1, 3, 7);

        matrix.setDistance(2, 4, 3);
        matrix.setDistance(2, 5, 1);
        matrix.setDistance(2, 6, 6);

        return matrix;
    }
}