package StacksAndQueues;

import java.util.Stack;
import java.util.Scanner;

public class ATaleOfTwoStacks {

    final static Stack<Integer> s1 = new Stack<>();
    final static Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        int i = 0;
        while(i < queries) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                // enqueue
                int item = sc.nextInt();
                enqueue(item);
            } else if (queryType == 2) {
                dequeue();
            } else {
                // print element at the front of the queue
                peek();
            }         
            i++;
        }
        sc.close();
    }

    public static void enqueue(int item) {
        s1.push(item);
    }

    public static int dequeue() throws Exception {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new Exception("Both stacks are empty");
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void peek() {
        System.out.println(s2.peek());
    }
}