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

    public int computeHours(int exitHour) {
        return Math.max(1, exitHour - entryHour);
    }

    public abstract double computeFee(int exitHour);

    public abstract String getCategory();
}