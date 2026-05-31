package queue;

import java.util.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dquee {

	public static void main(String[] args) {

		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		Iterator itrIterator = queue.iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
		
		queue.stream()
		.map(n -> n * 2)
		.forEach(System.out::println);
	}
	//Welcome Ritessh

}
