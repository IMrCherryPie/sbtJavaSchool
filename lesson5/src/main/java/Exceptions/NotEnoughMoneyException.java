package Exceptions;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String errorMessage) {
        super(errorMessage);
    }
}
