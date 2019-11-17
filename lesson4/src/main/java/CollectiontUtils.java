import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? super T> source, int size) {
        if ((source.size() == size) || (source.size() < size)) {
            return source;
        } else {
            return source.subList(0, size);
        }
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T element : c2) {
            if (c1.contains(element)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable> List range(List<? extends T> list, T min, T max) {
        ArrayList<T> copyList = list.stream()
                .filter(element -> (element.compareTo(max) <= 0) && (element.compareTo(min) >= 0))
                .collect(Collectors.toCollection(ArrayList::new));
        return copyList;
    }

    public static <T> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        ArrayList<T> copyList = new ArrayList<>(list);
        for (T element : list) {
            if ((comparator.compare(element, max) <= 0) && (comparator.compare(element, min) >= 0)) {
                copyList.add(element);
            }
        }
        return new ArrayList();
    }

}