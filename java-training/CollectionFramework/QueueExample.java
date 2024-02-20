package CollectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Queue is an interface and has it is extended by
        // Deque interface and implemented by PriorityQueue class.
        // LinkedList implements Deque interface.

        // The hierarchy looks like:
        // Queue interface -> Deque interface -> LinkedList class
        Queue<Integer> queue = new LinkedList<>();

        // adding elements in the queue
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
            // queue.add(i) can throw an exception if the queue is full
            // queue.offer(i) returns a boolean and does not affect the program
            // in such a case
        }

        // Displaying the contents of the queue
        System.out.println(queue.toString());
        System.out.println("Size: " + queue.size());

        // removing elements from the queue
        System.out.println("Removed: " + queue.poll());

        System.out.println("Resultant queue: " + queue.toString());
        System.out.println("Size: " + queue.size());

        // adding a value in the queue at the last
        queue.offer(11);
        System.out.println("After adding : " + queue.toString());
        System.out.println("Size: "+ queue.size());
    }
}
