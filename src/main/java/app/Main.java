package app;

import datastructures.FeeSorter;
import exceptions.LotCapacityException;
import exceptions.VehicleNotFoundException;
import model.Bike;
import model.Car;
import model.ParkingTicket;
import model.Vehicle;
import service.ParkingService;

import java.util.Scanner;

public class Main {
    private static final int TOTAL_SLOTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingService service = new ParkingService(TOTAL_SLOTS);

        while (true) {
            System.out.println("\n--- Parking Lot (Impl 2: HashMap + Selection Sort) ---");
            System.out.println("1. Vehicle Entry & Slot Allocation");
            System.out.println("2. Vehicle Exit & Fee Calculation");
            System.out.println("3. Occupancy & Sorted Fee Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    int freeSlot = service.findFreeSlot();
                    if (freeSlot == -1) {
                        throw new LotCapacityException("All " + TOTAL_SLOTS + " slots are occupied.");
                    }

                    System.out.print("Vehicle type (car/bike): ");
                    String type = scanner.nextLine().trim().toLowerCase();
                    System.out.print("License plate: ");
                    String plate = scanner.nextLine().trim().toUpperCase();
                    System.out.print("Entry hour (0-23): ");
                    int entryHour = scanner.nextInt();
                    scanner.nextLine();

                    Vehicle vehicle = type.equals("bike")
                            ? new Bike(plate, entryHour)
                            : new Car(plate, entryHour);

                    service.parkVehicle(freeSlot, plate, vehicle);
                    System.out.println("Allocated Slot #" + freeSlot + " to " + plate);

                } else if (choice == 2) {
                    System.out.print("Enter license plate for exit: ");
                    String plate = scanner.nextLine().trim().toUpperCase();
                    System.out.print("Exit hour (0-23): ");
                    int exitHour = scanner.nextInt();
                    scanner.nextLine();

                    ParkingTicket ticket = service.getTicket(plate);
                    double fee = service.releaseSlot(plate, ticket, exitHour);

                    System.out.println("Freed Slot #" + ticket.getSlotId() + ". Fee due: Rs. " + fee);
                } else if (choice == 3) {
                    System.out.println("\n=== Occupancy Report ===");
                    System.out.println("Active Vehicles: " + service.getActiveCount() + " / " + TOTAL_SLOTS);
                    for (ParkingTicket t : service.getActiveTickets()) {
                        Vehicle v = t.getVehicle();
                        System.out.println("Slot #" + t.getSlotId() + " -> [" + v.getCategory() + "] "
                                + v.getPlateNumber() + " (Entry: " + v.getEntryHour() + "h)");
                    }

                    int settledCount = service.getSettledCount();
                    if (settledCount > 0) {
                        double[] settledFees = service.getSettledFees();
                        String[] settledPlates = service.getSettledPlates();
                        double[] copyFees = new double[settledCount];
                        String[] copyPlates = new String[settledCount];
                        for (int i = 0; i < settledCount; i++) {
                            copyFees[i] = settledFees[i];
                            copyPlates[i] = settledPlates[i];
                        }
                        FeeSorter.sortByFeeDescending(copyFees, copyPlates, settledCount);
                        System.out.println("\n=== Settled Exits (Sorted High to Low Fee) ===");
                        for (int i = 0; i < settledCount; i++) {
                            System.out.println((i + 1) + ". " + copyPlates[i] + " - Rs. " + copyFees[i]);
                        }
                    }
                } else if (choice == 4) {
                    System.out.println("Closing system.");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (LotCapacityException | VehicleNotFoundException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
        scanner.close();
    }
}