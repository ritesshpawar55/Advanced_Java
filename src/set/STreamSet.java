package set;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class STreamSet {

	public static void main(String[] args) {
		
		Set<Integer> set = Set.of(70,90,30,40,50);
		set.stream().filter(n -> n > 30).forEach(System.out::println);
	
	}
	//Welcome Ritessh

}
