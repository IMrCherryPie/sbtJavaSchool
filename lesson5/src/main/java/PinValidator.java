import Exceptions.IncorrectPinException;
import Exceptions.LockException;

public class PinValidator implements interfaces.PinValidator {

    private String pin = "22333rr";
    private int Attempt = 0;
    private boolean validation = false;

    public boolean Validator(String userInput) throws LockException, IncorrectPinException {
        if (pin.equals(userInput)) {
            validation = true;
            return true;
        }
        if (Attempt == 2) {
            Attempt = 0;
            throw new LockException("Incorrect input for 3 times");
        }
        Attempt++;
        throw new IncorrectPinException("Incorrect input");
    }

    void endWork(){
        validation=false;
    }
}
