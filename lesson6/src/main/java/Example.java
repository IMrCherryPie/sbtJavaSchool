import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import static java.util.Collections.emptyList;

public class Example {


    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IntrospectionException {
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

//        analyzeClass(new Runtime<Integer>());


    }



    public static void analyzeClass(Object o) throws NoSuchFieldException, NoSuchMethodException, IntrospectionException {
        Class clazz = o.getClass();
        System.out.println("Имя класса: " + clazz);
        System.out.println("Поля класса: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Родительский класс: " + clazz.getSuperclass());
        System.out.println("Методы класса: " +  Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Конструкторы класса: " + Arrays.toString(clazz.getConstructors()));
        System.out.println("Generic-параметр через метод numbers: " + clazz.getMethod("numbers").getGenericReturnType());
        // Вывести все геттеры класса

        System.out.println("все геттеры класса");
        for(PropertyDescriptor propertyDescriptor :
                Introspector.getBeanInfo(clazz).getPropertyDescriptors()){

            // propertyEditor.getReadMethod() exposes the getter
            // btw, this may be null if you have a write-only property
            System.out.println(propertyDescriptor.getReadMethod());
        }
        // Проверить что все строковые константы имеют значения, равные их имени

//        for (Field f : clazz.getFields()){
//            String fieldName = f.getName();
//            System.out.println(fieldName);
//            try {
//                String fieldValue = (String) f.get(String.class);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static class Runtime<T extends Number>
            implements Callable<Double> {
        private final List<Integer> integers = emptyList();
        private Integer example = 2;

        public Integer getExample() {
            return example;
        }

        public List<T> numbers() {
            return emptyList();
        }

        private List<String> strings() {
            return emptyList();
        }

        @Override
        public Double call() {
            return 0d;
        }
    }
}
