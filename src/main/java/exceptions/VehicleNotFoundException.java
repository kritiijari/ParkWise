package exceptions;

// Custom exception thrown when a plate is not in the active tickets 
public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}