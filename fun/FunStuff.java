import java.text.BreakIterator;
import java.util.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class FunStuff {

    public static void selectionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
        }
    }

    public static void insertionSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else
                    break;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] numbers = new int[len];
        int asc = 1;
        int longest = 0;
        for (int i = 0; i < len; i++) {
            numbers[i] = sc.nextInt();
        }
        if(len > 1) {
            for (int i = 1; i < len; i++) {
                int pre = numbers[i - 1];
                int act = numbers[i];
                if (pre <= act) {
                    System.out.println("comparing <" + pre + ", " + act + ">");
                    ++asc;
                    System.out.println("asc: " + asc);
                } else {
                    if (longest <= asc) {
                        longest = asc;
                        System.out.println("lon: " + longest);
                        asc = 1;
                    }

                }
                if (i == len - 1 && longest <= asc) {
                    longest = asc;
                    System.out.println("end");
                    System.out.println("lon: " + longest);
                }

            }
        } else longest = 1;

        System.out.println(longest);
    }

}