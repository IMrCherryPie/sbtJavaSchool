package interfaces;

import Exceptions.IncorrectMoneyInputException;
import Exceptions.NotEnoughMoneyException;

public interface Terminal {
    boolean setBankAccount (double cash) throws IncorrectMoneyInputException;
    void getBankAccount ();
    boolean withdrawMoney (double cash) throws NotEnoughMoneyException, IncorrectMoneyInputException;
}
