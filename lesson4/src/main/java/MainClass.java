import java.util.Map;

public class MainClass {
    public static void main(String[] args) {

    }
    class TestCountMap<T> implements CountMap<T>{

        private class Node<T>{
            private T key;
            private int count;
            private Node<T> next;
        }

        public void add(T t) {

        }

        public int getCount(T t) {
            return getCount(t);
        }

        public int remove(T t) {
            return 0;
        }

        public int size() {
            return 0;
        }

        public void addAll(CountMap<T> source) {

        }

        public Map<T, Integer> toMap() {
            return null;
        }

        public void toMap(Map<T, Integer> destination) {

        }
    }

}
