package model;

// Stores one parking record: the vehicle and its slot number    
public class ParkingTicket {
    private final int slotId;
    private final Vehicle vehicle;

    public ParkingTicket(int slotId, Vehicle vehicle) {
        this.slotId = slotId;
        this.vehicle = vehicle;
    }

    public int getSlotId() {
        return slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}