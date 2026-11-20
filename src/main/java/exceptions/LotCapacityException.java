package exceptions;

// Custom exception thrown when no free slot is left 
public class LotCapacityException extends Exception {
    public LotCapacityException(String message) {
        super(message);
    }
}