package set;
import java.util.*;

public class Sett {
	
	public static void main(String[] args) {
		
		Set<Integer> list = new HashSet();
		
		list.add(101);
		list.add(103);
		list.add(103);
		list.add(1033);
		list.add(13);
		
		Iterator<Integer> itrIterator = list.iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
		
		System.out.println("*********************************");
		
		Set<Integer> list1 = new LinkedHashSet();
		
		list1.add(10);
		list1.add(11);
		list1.add(11);
		list1.add(10);
		list1.add(1);
		
		Iterator<Integer> itrIterator1 = list1.iterator();
		while(itrIterator1.hasNext()) {
			System.out.println(itrIterator1.next());
		}
		
		System.out.println("*********************************");
		
		Set<String> list2 = new TreeSet<>();
		
		list2.add("a");
		list2.add("v");
		list2.add("f");
		list2.add("d");
		list2.add("c");
		
//		Collections.sort(list);
		Iterator<String> itrIterator2= list2.iterator();
		while(itrIterator2.hasNext()) {
			System.out.println(itrIterator2.next());
		}
		
		System.out.println("*********************************");
		
		
		SortedSet<Integer> s = new TreeSet<>();
		s.add(12);
		s.add(11);
		s.add(2);
		s.add(121);
		
		Iterator<Integer> i = s.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println("*********************************");
		
		NavigableSet<Integer> s1 = new TreeSet<>();
		s1.add(12);
		s1.add(11);
		s1.add(2);
		s1.add(121);
		
		Iterator<Integer> i1 = s1.iterator();
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}
		
	}
	//Welcome Ritessh

}
