package model;

public class NotEnoughArgumentsException extends Exception {
    /**
     * @param message - the error message that will be returned when raising the exception
     */
    public NotEnoughArgumentsException(String message) {
        super(message);
    }

}
