package interfaces;

import Exceptions.IncorrectPinException;
import Exceptions.LockException;

public interface PinValidator {

   boolean Validator (String pin) throws IncorrectPinException, LockException, InterruptedException;
}
