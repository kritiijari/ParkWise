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

            if (choice == 4) {
                System.out.println("Closing system.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}