import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int numberOfItems;
    private Item[] items;

    public RandomizedQueue() {
        items = (Item[]) new Object[2];
        numberOfItems = 0;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public int size() {
        return numberOfItems;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (isFull()) {
            resize(2 * items.length);
        }
        items[numberOfItems++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int lastPosition = numberOfItems - 1;
        int randomPosition = StdRandom.uniform(numberOfItems);
        Item randomItem = getItem(lastPosition, randomPosition, this.items);
        numberOfItems--;
        if (numberOfItems > 0 && numberOfItems == items.length / 4) resize(items.length / 2);
        return randomItem;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomPosition = StdRandom.uniform(numberOfItems);
        return items[randomPosition];
    }

    private boolean isFull() {
        return numberOfItems == items.length;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < items.length; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    private Item getItem(int lastPosition, int randomPosition, Item[] fromItems) {
        Item randomItem = fromItems[randomPosition];
        Item lastItem = fromItems[lastPosition];
        fromItems[randomPosition] = lastItem;
        fromItems[lastPosition] = null;
        return randomItem;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int copy = numberOfItems;
        private final Item[] toIterate;

        QueueIterator() {
            toIterate = (Item[]) new Object[copy];
            for (int i = 0; i < copy; i++) {
                toIterate[i] = items[i];
            }
        }

        @Override
        public boolean hasNext() {
            return copy > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int lastPosition = copy - 1;
            int randomPosition = StdRandom.uniform(copy);
            Item randomItem = getItem(lastPosition, randomPosition, toIterate);
            copy--;
            return randomItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 99; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 99; i++) {
            System.out.println("dequeue = " + queue.dequeue());
        }

    }
}
