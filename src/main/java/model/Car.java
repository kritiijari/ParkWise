package model;

public class Car extends Vehicle {
    private static final double HOURLY_RATE = 40.0;

    public Car(String plateNumber, int entryHour) {
        super(plateNumber, entryHour);
    }

    @Override
    public double computeFee(int exitHour) {
        return computeHours(exitHour) * HOURLY_RATE;
    }

    @Override
    public String getCategory() {
        return "Car";
    }
}