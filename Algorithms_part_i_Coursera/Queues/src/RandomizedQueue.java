import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items = (Item[]) new Object[1];
    private int N = 0;

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isFull()) {
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return null; // TODO: change this
    }

    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return null; // TODO: change this too ...
    }

    private boolean isFull() {
        return N == items.length;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i >= 1;
        }

        @Override
        public Item next() {
            return items[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        for (int i = 1; i <= 100; i++) {
            queue.enqueue("Item " + i);
        }
        System.out.println(queue.size());
        for (String word : queue) {
            System.out.println(word);
        }
        System.out.println(queue.size());
    }
}
