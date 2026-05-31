package list;

import java.util.*;

public class Listtt {

	public static void main(String[] args) {
		
		System.out.println("*********************************");
		
		List<String> list = Arrays.asList(
				"Ritessh", "Raj", "Raj", "AMan", "Kashish", "Gundu", "Bebo"
		);
		
		List<String> result = list.stream()
			    .filter(n -> n.startsWith("R"))
			    .filter(x -> x.endsWith("j"))
			    .map(String::toUpperCase)
			    .filter(n -> n.length() > 2)
			    .toList();

			System.out.println(result );
			
			System.out.println("\n*********************************");	
			
			
			List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 4,2,3,3,2,4,4,435,4,57,68,68);

			List<Integer> unique = nums.stream()
					.distinct()
					.filter(n -> n > 2)
					.limit(22)
					.skip(0)
					.toList();

			System.out.println(unique);
				
			
			System.out.println("\n*********************************");
			
			
			
			
			
	}

}
