import java.util.Scanner;

/**
 * From HackerRank. New Year Chaos Problem It is New Year's Day and people are
 * in line for the Wonderland rollercoaster ride. Each person wears a sticker
 * indicating their initial position in the queue from 1 to n. Any person can
 * bribe the person directly in front of them to swap positions, but they still
 * wear their original sticker. One person can bribe at most two others.
 * Determine the minimum number of bribes that took place to get to a given
 * queue order. Print the number of bribes, or, if anyone has bribed more than
 * two people, print Too chaotic.
 */
public class NewYearChaos {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int t = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < t; i++) {
            displayIsTooChaoticOrBribes(readTestCase(n));
            if (i != t - 1) {
                n = sc.nextInt();
            }
        }

        sc.close();
    }

    private static void displayIsTooChaoticOrBribes(int[] arr) {
        int bribes = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, arr[i] - 2); j < i; j++) {
                if (arr[j] > arr[i]) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    private static int[] readTestCase(int n) {
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            queue[i] = sc.nextInt();
        }
        return queue;
    }
}