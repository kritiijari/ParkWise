package model;

public abstract class Vehicle {
    private final String plateNumber;
    private final int entryHour;

    public Vehicle(String plateNumber, int entryHour) {
        this.plateNumber = plateNumber.toUpperCase();
        this.entryHour = entryHour;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getEntryHour() {
        return entryHour;
    }
}