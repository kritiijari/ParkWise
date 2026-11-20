# ParkWise - Parking Lot Management System

# ParkWise: Parking Lot Management System

A Java console project (Scanner menu, no GUI, no database) for managing a small parking lot.

## Features

- Vehicle entry with automatic slot allocation
- Vehicle exit with fee calculation
- Occupancy report with settled fees sorted high to low

## How to Run

From the project root in PowerShell:

```
javac -d out -sourcepath src\main\java src\main\java\app\Main.java
java -cp out app.Main
```

## Requirement Mapping

| Requirement | Where it is used |
| --- | --- |
| Abstraction | `Vehicle` (model) |
| Inheritance | `Car` and `Bike` extend `Vehicle` |
| Polymorphism | `computeFee()` overridden in `Car` and `Bike` |
| Encapsulation | Private fields with getters in `Vehicle`, `ParkingTicket`, `ParkingService` |
| Custom exceptions | `LotCapacityException`, `VehicleNotFoundException` |
| Self-written DSA | `FeeSorter` (selection sort) |
| Java collection | `HashMap` of active tickets in `ParkingService` |

## Project Structure

- `app`: `Main` (console menu)
- `model`: `Vehicle`, `Car`, `Bike`, `ParkingTicket`
- `service`: `ParkingService`
- `datastructures`: `FeeSorter`
- `exceptions`: custom exceptions
