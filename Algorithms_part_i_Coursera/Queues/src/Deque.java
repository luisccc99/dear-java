import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: use doubly-linked list implementation
public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node last;
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return null;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeueIterator();
    }

    private class DequeueIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {

    }

}
