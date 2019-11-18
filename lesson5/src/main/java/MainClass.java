import Exceptions.IncorrectMoneyInputException;
import Exceptions.IncorrectPinException;
import Exceptions.LockException;
import Exceptions.NotEnoughMoneyException;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws IncorrectMoneyInputException, NotEnoughMoneyException, LockException, IncorrectPinException {
        TerminalImpl terminal  = new TerminalImpl();
        PinValidator pinvalidator = new PinValidator();
        while (true) {
            System.out.println("Введите пароль");
            if (pinvalidator.Validator(new Scanner(System.in).next())) {
                System.out.println("Приложте карту к терминалу и выерите действие:\n" +
                        "--1--  Узнать сколько средств на счёте\n" +
                        "--2--  Положить на счёт средства\n" +
                        "--3--  Снять деньги со счёта\n"
                );
                switch (new Scanner(System.in).next()) {
                    case ("1"):
                        terminal.getBankAccount();
                        break;
                    case ("2"):
                        if (terminal.setBankAccount(1000D))
                            System.out.println("Сумма внесена");
                        break;
                    case ("3"):
                        if (terminal.withdrawMoney(1000d))
                            System.out.println("Исполнено");
                        break;
                    default:
                        System.exit(0);
                }
            }
        }
    }
}
