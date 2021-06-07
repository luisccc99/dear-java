/**
 * From HackerRank.
 * In this challenge, you must first implement a queue using two stacks.
 * Then process queries, where each query is one of the following types:
 *   1 x: Enqueue element into the end of the queue.
 *   2: Dequeue the element at the front of the queue.
 *   3: Print the element at the front of the queue.
 * 
 */

package StacksAndQueues;

import java.util.Stack;
import java.util.Scanner;

public class ATaleOfTwoStacks {

    final private static Stack<Long> s1 = new Stack<>();
    final private static Stack<Long> s2 = new Stack<>();

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        int i = 0;
        while(i < queries) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                long item = sc.nextLong();
                enqueue(item);
            } else if (queryType == 2) {
                dequeue();
            } else {
                peek();
            }         
            i++;
        }
        sc.close();
    }

    public static void enqueue(long item) {
        s1.push(item);
    }

    public static long dequeue() throws Exception {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new Exception("Both stacks are empty");
        }
        if (s2.isEmpty()) {
            transfer(s1, s2);
        }
        return s2.pop();
    }

    private static void transfer(Stack<Long> s1, Stack<Long> s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public static void peek() {
        System.out.println(s2.isEmpty()? s1.firstElement() : s2.peek());
    }
}