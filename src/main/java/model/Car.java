package model;

// Child class of Vehicle (inheritance); fee rule for cars 

public class Car extends Vehicle {
    private static final double HOURLY_RATE = 40.0;

    public Car(String plateNumber, int entryHour) {
        super(plateNumber, entryHour);
    }

    // Overrides(hild class provides its own implementation of a method that is
    // already defined in its parent class) computeFee with the car rate
    @Override
    public double computeFee(int exitHour) {
        return computeHours(exitHour) * HOURLY_RATE;
    }

    @Override
    public String getCategory() {
        return "Car";
    }
}