import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

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
            throw new java.util.NoSuchElementException();
        }
        int lastPosition = numberOfItems - 1;
        int randomPosition = StdRandom.uniform(numberOfItems);
        Item randomItem = getItem(lastPosition, randomPosition, this.items);
        numberOfItems--;
        if (numberOfItems > 0 && numberOfItems == items.length / 4) resize(size() / 2);
        return randomItem;
    }

    public Item sample() {
        int randomPosition = StdRandom.uniform(numberOfItems);
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return items[randomPosition];
    }

    private boolean isFull() {
        return numberOfItems == items.length;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < numberOfItems; i++) {
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
        private int N = numberOfItems;
        private Item[] toIterate;

        QueueIterator() {
            toIterate = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                toIterate[i] = items[i];
            }
        }

        @Override
        public boolean hasNext() {
            return N > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            int lastPosition = N - 1;
            int randomPosition = StdRandom.uniform(N);
            Item randomItem = getItem(lastPosition, randomPosition, toIterate);
            N--;
            return randomItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        int n = 5;
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (int a : queue) {
            for (int b : queue)
                System.out.print(a + "-" + b + " ");
            System.out.println();
        }

    }
}
