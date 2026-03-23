package main.java.com.parkinglot.util;

import java.util.HashMap;
import java.util.Map;

// Stores distance between gate and slot
public class DistanceMatrix {

    // gateId -> (slotId -> distance)
    private Map<Integer, Map<Integer, Integer>> matrix = new HashMap<>();

    public void setDistance(int gateId, int slotId, int distance) {
        matrix
                .computeIfAbsent(gateId, k -> new HashMap<>())
                .put(slotId, distance);
    }

    public int getDistance(int gateId, int slotId) {
        return matrix.getOrDefault(gateId, new HashMap<>())
                .getOrDefault(slotId, Integer.MAX_VALUE);
    }
}