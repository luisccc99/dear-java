import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> words = new RandomizedQueue<>();
        int k = StdIn.readInt();
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            words.enqueue(word);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(words.dequeue());
        }
    }
}
