import Exceptions.LockException;

public class PinValidator implements interfaces.PinValidator {

    private String pin = "226228";
    private int attempt = 0;

    public boolean Validator(String userInput) throws LockException, InterruptedException {
        if (pin.equals(userInput)) {
            return true;
        }
        if (attempt == 2) {
            attempt = 0;
            System.out.println("Вы ввели пароль неправильно трижды. Наряд выехал. Повторное введение пароля бедет доступно через 5 секунд");
            Thread.sleep(5000);
//            throw new LockException("Incorrect input for 3 times");
        }else {
            attempt += 1;
            System.out.println("Неверный пароль");
        }
            return false;
    }
}
