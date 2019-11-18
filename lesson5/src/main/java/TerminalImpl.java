import Exceptions.IncorrectMoneyInputException;
import Exceptions.NotEnoughMoneyException;
import interfaces.Terminal;

public class TerminalImpl extends TerminalServerImpl implements Terminal {

    public boolean setBankAccount(double cash) throws IncorrectMoneyInputException {
        if (cash % 100 != 0) throw new IncorrectMoneyInputException("Incorrect money input. (The machine gives out a multiple of 100)");
        {
            bankAccount += cash;
            return true;
        }
    }

    public void getBankAccount(){
        System.out.println(bankAccount);
    }

    @Override
    public boolean withdrawMoney(double cash) throws NotEnoughMoneyException, IncorrectMoneyInputException {
        if (cash % 100 != 0 || cash <= 0)
            throw new IncorrectMoneyInputException("You may get anything that is multipled by 100 and is not a zero");
        if (bankAccount - cash < 0)
            throw new NotEnoughMoneyException("Not enough maney on the account");
        bankAccount -= cash;
        return true;
    }
}
