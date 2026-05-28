package list;

import java.util.*;

public class Product {
	
	int id;
	String name;
	String category;
	double price;

	
	public Product(int id, String name, String category, double price) {

		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " " + price;
	}


	public static void main(String[] args) {
		
		List<Product> l = Arrays.asList(
				new Product(101, "deeraj", "fashison", 2500.01),
				new Product(201, "aman", "mobile", 5500.01),
				new Product(301, "gundu", "accessory", 7500.01),
				new Product(401, "bebo", "jewels", 5400.01)
				);
		
		List<Product> expensive = l.stream()
				.filter(n -> n.price > 5000)
				.toList();
		System.out.println(expensive);
		
		System.out.println("\n*********************************");
		
		List<String> namesList = l.stream()				
				.map(p -> p.name)
				.toList();
		System.out.println(namesList);
		
		System.out.println("\n*********************************");
		
		List<Product> descList = l.stream()
				.sorted((a,b) -> Double.compare(b.price, a.price))
				.toList();
		System.out.println(descList);
		
		System.out.println("\n*********************************");
		
		
		
		
	
	}
}
