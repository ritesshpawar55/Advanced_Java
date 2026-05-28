package queue;

import java.util.*;

public class QueueBusinessLogic {

    public static void main(String[] args) {

        // NORMAL QUEUE
        Queue<String> orders =
                new LinkedList<>();

        orders.offer("Burger");
        orders.offer("Pizza");
        orders.offer("Pasta");

        System.out.println("Orders Queue:");
        System.out.println(orders);

        // PROCESS FIRST ORDER
        System.out.println("\nProcessing Order:");
        System.out.println(orders.poll());

        System.out.println("\nRemaining Orders:");
        System.out.println(orders);

        // PRIORITY QUEUE
		PriorityQueue<Integer> priorityOrders = new PriorityQueue<>();

        priorityOrders.offer(3);
        priorityOrders.offer(1);
        priorityOrders.offer(2);

        System.out.println("\nPriority Orders:");
        System.out.println(priorityOrders);

        System.out.println("\nHighest Priority:");
        System.out.println(priorityOrders.poll());

        // DEQUE
		Deque<String> urgentOrders = new ArrayDeque<>();

        urgentOrders.addFirst("VIP Order");
        urgentOrders.addLast("Normal Order");

        System.out.println("\nDeque Orders:");
        System.out.println(urgentOrders);

        // STREAM API
		Queue<Integer> bills = new LinkedList<>();

        bills.offer(100);
        bills.offer(250);
        bills.offer(80);
        bills.offer(400);

        System.out.println("\nBills Greater Than 100:");

        bills.stream()
                .filter(b -> b > 100)
                .forEach(System.out::println);

        // MAP
        System.out.println("\nGST Added Bills:");

        bills.stream()
                .map(b -> b + 18)
                .forEach(System.out::println);

        // REMOVE USING LAMBDA
        bills.removeIf(b -> b < 100);

        System.out.println("\nAfter Removing Small Bills:");
        System.out.println(bills);
    }
}