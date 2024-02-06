package resturentbooking.exception;

public class RestaurantException extends RuntimeException {
    RestaurantException(String message) {
        super(message);
    }

    public RestaurantException(String message, Throwable cause) {
        super(message, cause);
    }
}
