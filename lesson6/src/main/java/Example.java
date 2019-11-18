import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import static java.util.Collections.emptyList;

public class Example {


    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        HashMap<String, String> map = new HashMap();
        Class clazz = map.getClass();

        System.out.println(clazz);

        Runtime s = new Runtime();

        /*Class test = s.getClass();
        Constructor[] constructor = test.getConstructors();
        Constructor constructors1 = test.getConstructor();
        Constructor[] constructors2 = test.getDeclaredConstructors();
        Class[] constructors3 = test.getClasses();
        Class constructor4 = test.getComponentType();*/

        analyzeClass(new Runtime<Integer>());

    }



    public static void analyzeClass(Object o) throws NoSuchFieldException, NoSuchMethodException {
        Class clazz = o.getClass();
        System.out.println("Имя класса: " + clazz);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Родительский класс: " + clazz.getSuperclass());
        System.out.println("Методы класса: " +  Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
        System.out.println("Generic-параметр через метод numbers: " + clazz.getMethod("numbers").getGenericReturnType());
    }

    public static class Runtime<T extends Number>
            implements Callable<Double> {
        private final List<Integer> integers = emptyList();

        public List<T> numbers() {
            return emptyList();
        }

        public List<String> strings() {
            return emptyList();
        }

        @Override
        public Double call() {
            return 0d;
        }
    }
}
