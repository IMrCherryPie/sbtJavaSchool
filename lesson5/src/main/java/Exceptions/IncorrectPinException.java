package Exceptions;

public class IncorrectPinException extends Exception {
    public IncorrectPinException(String errorMessage) {
        super(errorMessage);
    }
}
