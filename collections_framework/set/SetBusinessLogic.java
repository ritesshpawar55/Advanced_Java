package set;

import java.util.*;
import java.util.stream.Collectors;

public class SetBusinessLogic {

    public static void main(String[] args) {

        // HASHSET
        Set<String> employeeSkills = new HashSet<>();

        employeeSkills.add("Java");
        employeeSkills.add("Python");
        employeeSkills.add("Docker");
        employeeSkills.add("Java");

        System.out.println("HashSet Skills:");
        employeeSkills.forEach(System.out::println);

        // LINKEDHASHSET
        Set<String> orderedSkills = new LinkedHashSet<>();

        orderedSkills.add("Spring");
        orderedSkills.add("React");
        orderedSkills.add("MongoDB");

        System.out.println("\nLinkedHashSet:");
        orderedSkills.forEach(System.out::println);

        // TREESET
		NavigableSet<Integer> employeeRatings = new TreeSet<>();

        employeeRatings.add(90);
        employeeRatings.add(70);
        employeeRatings.add(85);
        employeeRatings.add(95);

        System.out.println("\nSorted Ratings:");
        System.out.println(employeeRatings);

        // NAVIGABLESET METHODS
		System.out.println("\nLower than 90: " + employeeRatings.lower(90));

		System.out.println("Higher than 85: " + employeeRatings.higher(85));

		System.out.println("Floor of 88: " + employeeRatings.floor(88));

		System.out.println("Ceiling of 88: " + employeeRatings.ceiling(88));

        // STREAM API
        System.out.println("\nFiltered Ratings > 80:");

        employeeRatings.stream()
                .filter(r -> r > 80)
                .forEach(System.out::println);

        // MAP OPERATION
        System.out.println("\nBonus Ratings:");

        employeeRatings.stream()
                .map(r -> r + 5)
                .forEach(System.out::println);

        // COLLECT TO NEW SET
        Set<Integer> updatedRatings =
                employeeRatings.stream()
                        .map(r -> r + 10)
                        .collect(Collectors.toSet());

        System.out.println("\nUpdated Ratings:");
        System.out.println(updatedRatings);

        // REMOVE USING LAMBDA
        updatedRatings.removeIf(r -> r < 90);

        System.out.println("\nAfter Removing < 90:");
        System.out.println(updatedRatings);
    }
}
