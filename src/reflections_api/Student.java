package reflections_api;

import java.lang.reflect.*;

class Student {

	private int id;
	private String name;

	public void show() {}

	private void test() {}

	public static void main(String[] args) {

		Class<?> c = Student.class;

		System.out.println("Class: " + c.getName());

		System.out.println("\nFields:");

		for (Field f : c.getDeclaredFields()) {
			System.out.println(f.getName());
		}

		System.out.println("\nMethods:");

		for (Method m : c.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
	}
}
