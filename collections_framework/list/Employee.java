package list;

import java.util.*;
import java.util.stream.*;

class Employee {

    int id;
    String name;
    String department;
    double salary;

	Employee(int id, String name, String department, double salary) {

		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

    public String toString() {
        return name + " " + salary;
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

            new Employee(1,"Ritesh","IT",70000),
            new Employee(2,"Aman","HR",40000),
            new Employee(3,"Rahul","IT",90000),
            new Employee(4,"Neha","Finance",50000)
        );

        // High salary employees

        List<Employee> highSalary =
            employees.stream()
                .filter(e -> e.salary > 50000)
                .toList();

        System.out.println(highSalary);

        // Names only

        List<String> names =
            employees.stream()
                .map(e -> e.name)
                .toList();

        System.out.println(names);

        // Total salary

        double total =
            employees.stream()
                .map(e -> e.salary)
                .reduce(0.0, Double::sum);

        System.out.println(total);

        // Group by department

        Map<String, List<Employee>> grouped =
            employees.stream()
                .collect(Collectors.groupingBy(
                    e -> e.department
                ));

        System.out.println(grouped);

        // Highest salary employee

		Employee max = employees.stream().max((a, b) -> Double.compare(a.salary, b.salary)).orElse(null);

        System.out.println(max);
    }
}