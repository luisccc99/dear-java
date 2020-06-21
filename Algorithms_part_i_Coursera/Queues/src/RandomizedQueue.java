import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items = (Item[]) new Object[1];
    private int numberOfItems = 0;
    private int randomPosition;

    public RandomizedQueue() {

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
            throw new java.util.NoSuchElementException();
        }
        int lastPosition = numberOfItems - 1;
        randomPosition = StdRandom.uniform(numberOfItems - 1);
        Item randomItem = items[randomPosition];
        Item lastItem = items[lastPosition];
        items[lastPosition] = randomItem;
        items[randomPosition] = lastItem;
        if (numberOfItems > 0 && numberOfItems == items.length / 4) resize(size() / 2);
        return items[--numberOfItems];
    }

    public Item sample() {
        randomPosition = StdRandom.uniform(numberOfItems - 1);
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return items[randomPosition];
    }

    private boolean isFull() {
        return numberOfItems == items.length;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < numberOfItems; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int i = numberOfItems;

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
        // TODO: implement client program
    }
}
