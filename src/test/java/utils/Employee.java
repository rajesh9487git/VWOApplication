package utils;

public class Employee implements Student {

	public static void main(String[] args) {

		Student s = new Employee();

		Employee e = new Employee();

	}

	@Override
	public void display() {
		System.out.println("Displaying in employee class");

	}

	@Override
	public void show() {

		System.out.println("Showing in employee class");

	}

	public void running() {

		System.out.println("Running in employee class");
	}

	public void walking() {

		System.out.println("walking in employee class");
	}

}
