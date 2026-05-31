package reflections_api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

	int id = 104;
	String nameString = "Ritessh";

	void show() {
		System.out.println("ID: " + id + " & " + "NAme: " + nameString);
	}

	public static void main(String[] args) throws ClassNotFoundException {

//		Class<?> class1 = Class.forName("ReflectionDemo");
		Class<?> c = ReflectionDemo.class;
		Field[] fields = c.getDeclaredFields();
		Method[] methods = ReflectionDemo.class.getDeclaredMethods();

		for (Method m : methods) {
			System.out.println(m.getName());
		}
		System.out.println("*******************************");
		for (Field f : fields) {
			System.out.println(f.getName());
		}

		System.out.println("*******************************");

		ReflectionDemo r = new ReflectionDemo();
		r.show();
	}
	// Welcome Ritessh

}
