/*
 * Problem from JetBrains Academy - Find the Seed
 * Your job is to find the seed between A and B (both inclusively)
 * that produces N pseudorandom numbers from 0 (inclusive) to K (exclusive).
 * It should also have the maximum of these N numbers to be the minimum 
 * among all maximums of other seeds in this range.
 * 
 * Sounds complicated? Take a look at the example.
 *
 * Here we have A = 7, B = 9, N = 4, K = 100. Let's suppose:
 *
 * For the seed 7, we get the sequence 45, 99, 23, 67 – the maximum is 99.
 * For the seed 8, we get 64, 34, 23, 9 – the maximum is 64.
 * For the seed 9, we get 78, 34, 0, 11 – the maximum is 78.
 *
 * Then the minimum among these maximums is 64. That means, in this example,
 * the seed we are looking for is 8. 
 */

import java.util.Scanner;
import java.util.Random;

public class FindTheSeed {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        int[] maximums = new int[b - a + 1];
        Random random = new Random();
        for (int i = 0; i <= b - a; i++) {
            int maxSoFar = Integer.MIN_VALUE;
            int pseNum = 0;
            random.setSeed(b - i);
            for (int j = 0; j < n; j++) {
                pseNum = random.nextInt(k);
                if (pseNum > maxSoFar) {
                    maxSoFar = pseNum;
                }
            }
            maximums[i] = maxSoFar;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < maximums.length; i++) {
            if (maximums[i] < min) {
                min = maximums[i];
                minIndex = i;
            }
        }
        int seed = 0;
        for (int i = 1; i < maximums.length; i++) {
            if (maximums[i] != maximums[i - 1]) {
                seed =  b - minIndex;
                break;
            }
        }
        System.out.println(seed + "\n" + maximums[minIndex]);
    }
}