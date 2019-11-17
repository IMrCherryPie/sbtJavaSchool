import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> extends ArrayList<T> {

    @Override
    public Iterator<T> iterator(){ return new MyIterator();}

    private class MyIterator implements Iterator<T> {
        private int curIndex = size() - 1;

        MyIterator(){}

        @Override
        public boolean hasNext() {
            return curIndex >= 0;
        }

        @Override
        public T next() {
            if (curIndex < 0){
                throw new NoSuchElementException();
            }
            return get(curIndex--);
        }
    }
}