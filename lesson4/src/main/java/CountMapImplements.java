import java.util.HashMap;
import java.util.Map;

class CountMapImplements<T> implements CountMap<T> {

    private Node<T> firstElement = null;

    private class Node<T> {
        private T key;
        private int count = 0;
        private Node<T> next = null;

        private Node(T t) {
            this.key = t;
            this.count = 1;
        }
    }

    public void add(T t) {
        if (firstElement == null) {
            firstElement = new Node<T>(t);
            return;
        }
        if (this.getCount(t) == 0) {
            Node<T> temp = firstElement;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node<T>(t);
            return;
        }
        Node<T> temp = firstElement;
        if (temp.key == t) {
            temp.count++;
            return;
        }
        if (temp.next != null)
            do {
                temp = temp.next;
                if (temp.key == t) {
                    temp.count++;
                    return;
                }
            } while (temp.next != null);
    }

    public int getCount(T t) {
        if (firstElement == null) return 0;
        Node<T> temp = firstElement;
        if (temp.key == t) return temp.count;
        if (temp.next != null) {
            do {
                temp = temp.next;
                if (temp.key == t) return temp.count;
            } while (temp.next != null);
        }
        return 0;
    }

    public int remove(T t) {
        if (firstElement == null) return 0;
        int countElem = 0;
        if (firstElement.next == null && firstElement.key == t) {
            countElem = firstElement.count;
            firstElement = null;
            return countElem;
        }

        Node<T> temp = firstElement;
        if (temp.key == t) {
            countElem = temp.count;
            firstElement = temp.next;
            return countElem;
        } else {
            do {
                if (temp.next.key == t) {
                    countElem = temp.next.count;
                    temp.next = temp.next.next;
                    return countElem;
                }
                temp = temp.next;
            } while (temp.next != null);
        }
        return 0;
    }

    public int size() {
        if (firstElement == null) return 0;
        Node<T> temp = firstElement;
        if (temp.next != null) {
            int count = 1;
            do {
                temp = temp.next;
                count++;
            } while (temp.next != null);
            return count;
        } else return 1;
    }

    public void addAll(CountMap<T> source) {
        Map<T, Integer> temp = source.toMap();
        for (Map.Entry<T, Integer> t : temp.entrySet()) {
            for (int i = 0; i < t.getValue(); i++)
                this.add(t.getKey());
        }
    }

    public Map<T, Integer> toMap() {
        if (firstElement == null) return null;
        Map<T, Integer> hashmap = new HashMap<T, Integer>();
        if (firstElement.next == null) hashmap.put(firstElement.key, firstElement.count);
        else {
            Node<T> temp = firstElement;
            hashmap.put(temp.key, temp.count);
            while (temp.next != null) {
                temp = temp.next;
                hashmap.put(temp.key, temp.count);
            }
        }
        return hashmap;
    }

    public void toMap(Map<T, Integer> destination) {
        if (firstElement == null) return;
        if (firstElement.next == null) destination.put(firstElement.key, firstElement.count);
        else {
            Node<T> temp = firstElement;
            destination.put(temp.key, temp.count);
            while (temp.next != null) {
                temp = temp.next;
                destination.put(temp.key, temp.count);
            }
        }
    }
}