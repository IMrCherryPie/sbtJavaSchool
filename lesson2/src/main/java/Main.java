import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> listPersons = createListPerson();
        writeList(listPersons);
        System.out.println("Начинаем попытки женить. Разводить для повторных браков");
        for (int i = 0; i < listPersons.size() - 1; i++) {
            tryingToMarry(listPersons);
            writeList(listPersons);
        }
    }
    private static ArrayList<Person> createListPerson() {
        ArrayList<Person> listPersons = new ArrayList<Person>();
        listPersons.add(new Person("Петров Виктор Иванович",true));
        listPersons.add(new Person("Петрова Анастрасия Ивановна",false));
        listPersons.add(new Person("Гаврилов Анатолий Фёдорович",true));
        listPersons.add(new Person("Фёдоровная Анастрасия Викторовна",false));
        listPersons.add(new Person("Грек Муса Евритович",true));
        listPersons.add(new Person("Тейлор Мишель Момсен",false));
        return listPersons;
    }

    private static void tryingToMarry(ArrayList<Person> listPerson1s) {
        Random rand = new Random();
        int n1 = rand.nextInt(listPerson1s.size());
        int n2 = rand.nextInt(listPerson1s.size());
        System.out.println("----------------------------------------");
        System.out.println("Делает предложение " + listPerson1s.get(n1) + " Избранница " + listPerson1s.get(n2));
        if (listPerson1s.get(n1).marry(listPerson1s.get(n2))) System.out.println("!!!Успех!!!");
        else System.out.println("===Жестокая правда жизни===");
        System.out.println("----------------------------------------");
    }

    private static void writeList(ArrayList<Person> journal) {
        System.out.println("Список сотрудников:");
        for (Person person : journal) System.out.println(person);
        System.out.println();
    }
}
