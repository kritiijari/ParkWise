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
}