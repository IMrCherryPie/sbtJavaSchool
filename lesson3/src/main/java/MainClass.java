import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainClass {
    private static HashMap<String, Integer> hashMapWords;
    private static HashMap<String, Integer> hashMapLetterWord;
    private static ArrayList<String> textList;
    private static Object Scanner;

    public static void main(String[] args) {
        hashMapWords = new HashMap<>();
        hashMapLetterWord = new HashMap<>();
        StringBuilder str = readFile();
        printSortedWord(hashMapWords);
        /*for (Map.Entry<String, Integer> entry: hashMapLetterWord.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        printSortedWord(hashMapWords); // Печать отсортированных, уникальных слов, по алфавиту
        printWord(hashMapLetterWord); // Печать слов в зависимости от длины
        printWord(hashMapWords); // печать слов в зависимости от частоты появления
        printRevesString(str); // Печать реверс строк

        ArrayList<Integer> input = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите желаемые строки через клавишу enter, для окончания ввода напишите end");
        while(true) {
            String current = scan.next();
            if (current.equals("end")) break;
            if (current.matches("^\\d*$")) // для списка из 1 млн целых чисел и не чисел)
                input.add(Integer.parseInt(current));
        }
        System.out.println(input);

        printStringRows(str, input); // Печать строк заданных пользователем


    }

    private static void printWord(HashMap<String, Integer> hashMapLetterWord) {
        hashMapLetterWord.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    // Печать отсортированных слов по алфавиту
    private static void printStringRows(StringBuilder string ,ArrayList<Integer> rows) {
        String[] lines = string.toString().split("\\n");
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(lines[rows.get(i)]);
        }
    }
    // Печать отсортированных слов по алфавиту
    private static void printSortedWord(HashMap map) {
        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list);
        list.forEach(System.out::println);
    }
    // Выводит строки в обратном порядке
    private static void printRevesString(StringBuilder str){
        StringBuilder strCopy = new StringBuilder(str);
        while( strCopy.lastIndexOf("\n") != -1) {
            int i = strCopy.lastIndexOf("\n");
            String newStr = strCopy.substring(i,strCopy.length()-1);
            System.out.println(newStr);
            strCopy.setLength(i);
            if (strCopy.lastIndexOf("\n")  == -1)
                System.out.println(strCopy);
        }

    }
    // Проверяет валидные символы для вычлинения слов
    private  static boolean validateChar(int ch) {
        return (ch <= 90 && ch >= 65) || (ch <= 1103 && ch >= 1040) || (ch <= 122 && ch >= 97);
    }
    // Подсчёт слов, без повторений
    private static void countWord(StringBuilder word){

        if ((hashMapWords.getOrDefault(word.toString(),-1) != -1)) {
            hashMapWords.put(word.toString(), (hashMapWords.get(word.toString()) + 1));
        } else {
            hashMapWords.put(word.toString(), 1);
        }
    }
    // подсчёт букв в слове, слова без повторений
    private static void coutnLetterInWord(String word, int value){
        if ((hashMapLetterWord.getOrDefault(word,-1) == -1)) {
            hashMapLetterWord.put(word, value);
        }
    }
    // Считывание текста из файла
    private static StringBuilder readFile(){
        StringBuilder text = new StringBuilder();
        try(
                FileReader reader = new FileReader("D:\\СберТех\\sbtJavaSchool\\lesson3\\src\\main\\src\\text.txt")) {
            // читаем посимвольно
            int c;
            StringBuilder str = new StringBuilder();
            while ((c = reader.read()) != -1) {
                text.append((char)c);
                if(validateChar(c)) {
                    str.append((char) c);
                }
                else{
                    countWord(str);
                    coutnLetterInWord(str.toString(), str.length());
                    str = new StringBuilder();
                }
            }
        }
        catch(
                IOException ex){

            System.out.println(ex.getMessage());
        }
        return text;
    }

}
