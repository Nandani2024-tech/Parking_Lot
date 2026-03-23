// Represents a vehicle entering the parking lot

package main.java.com.parkinglot.model;

import main.java.com.parkinglot.enums.VehicleType;

public class Vehicle {

    private String vehicleNumber;
    private String color;
    private String model;
    private VehicleType type;

    public Vehicle(String vehicleNumber, String color, String model, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.model = model;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getType() {
        return type;
    }
}