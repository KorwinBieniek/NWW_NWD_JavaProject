package model;

public class NegativeValuesException extends Exception {
    /**
     * @param message - the error message that will be returned when raising the exception
     */
    public NegativeValuesException(String message) {
        super(message);
    }
}
