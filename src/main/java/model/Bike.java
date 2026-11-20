package model;

public class Bike extends Vehicle {
    private static final double HOURLY_RATE = 20.0;

    public Bike(String plateNumber, int entryHour) {
        super(plateNumber, entryHour);
    }

    @Override
    public double computeFee(int exitHour) {
        return computeHours(exitHour) * HOURLY_RATE;
    }

    @Override
    public String getCategory() {
        return "Bike";
    }
}