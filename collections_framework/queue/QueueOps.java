package queue;

import java.util.*;

public class QueueOps {

	public static void main(String[] args) {
		
		Queue<String> q = new PriorityQueue<>();
		
		q.offer("ritessh");
		q.offer("aditii");
		q.offer("pawar");
		q.offer("mom");
		q.offer("sis");
		q.offer("sis");
		
		Iterator itrIterator = q.iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
	}
}
