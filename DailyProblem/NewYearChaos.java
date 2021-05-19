import java.lang.management.BufferPoolMXBean;
import java.util.Scanner;

/**
 * 
 */
public class NewYearChaos {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int t = sc.nextInt();
        int n = sc.nextInt();
        final int[][] testsCases = new int[t][n];
        int[] testCase = new int[n];
        for (int i = 0; i < t; i++) {
            System.out.println("n=" + n);
            testsCases[i] = readTestCase(n);
            if (i != t - 1) {
                n = sc.nextInt();
            }
        }
        sc.close();
        int[] minBribes = getNumberOfBribes(testsCases[t-2], n);
        int[] totalBribes = getNumberOfBribes(testsCases[t-1], n);
        boolean isTooChaotic = false;
        for (int i = 0; i < n; i++) {
            if(totalBribes[i] > 2) {
                isTooChaotic = true;
                break;
            }
        }
        String tooChaotic = isTooChaotic? "\nToo Chaotic" : "";
        System.out.println(totalOf(minBribes) + tooChaotic);
        //int totalBribes = getNumberOfBribes(testsCases[t-1], n);
    }

    private static int[] readTestCase(int n) {
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            queue[i] = sc.nextInt();
        }
        return queue;
    }

    private static int[] getNumberOfBribes(int[] secondLastCase, int n) {
        int[] bribes = new int[n];
        for (int i = n; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == secondLastCase[j]) {
                    int bribe = i - j - 1;
                    bribes[i - 1] += bribe > 0? bribe : 0;
                    continue;
                }
            }
        }
        return bribes;
    }

    private static int totalOf(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }
}