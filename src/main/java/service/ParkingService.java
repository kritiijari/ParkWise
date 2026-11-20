package service;

import exceptions.VehicleNotFoundException;
import model.ParkingTicket;
import model.Vehicle;

import java.util.Collection;
import java.util.HashMap;

public class ParkingService {
    private boolean[] slotOccupied;
    private HashMap<String, ParkingTicket> activeTickets = new HashMap<>();

    private double[] settledFees = new double[100];
    private String[] settledPlates = new String[100];
    private int settledCount = 0;

    public ParkingService(int totalSlots) {
        slotOccupied = new boolean[totalSlots];
    }

    public int findFreeSlot() {
        for (int i = 0; i < slotOccupied.length; i++) {
            if (!slotOccupied[i]) {
                return i + 1; // 1-based slot ID
            }
        }
        return -1;

    }

    public void parkVehicle(int freeSlot, String plate, Vehicle vehicle) {
        slotOccupied[freeSlot - 1] = true;
        activeTickets.put(plate, new ParkingTicket(freeSlot, vehicle));
    }

    public ParkingTicket getTicket(String plate) throws VehicleNotFoundException {
        ParkingTicket ticket = activeTickets.get(plate);
        if (ticket == null) {
            throw new VehicleNotFoundException("Plate " + plate + " is not currently parked.");
        }
        return ticket;
    }

    public double releaseSlot(String plate, ParkingTicket ticket, int exitHour) {
        double fee = ticket.getVehicle().computeFee(exitHour);
        slotOccupied[ticket.getSlotId() - 1] = false;
        activeTickets.remove(plate);

        if (settledCount < settledFees.length) {
            settledFees[settledCount] = fee;
            settledPlates[settledCount] = plate;
            settledCount++;
        }
        return fee;
    }

    public Collection<ParkingTicket> getActiveTickets() {
        return activeTickets.values();
    }

    public int getActiveCount() {
        return activeTickets.size();
    }

    public double[] getSettledFees() {
        return settledFees;
    }

    public String[] getSettledPlates() {
        return settledPlates;
    }

    public int getSettledCount() {
        return settledCount;
    }
}
