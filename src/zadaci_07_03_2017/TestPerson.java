package zadaci_07_03_2017;

class Person {
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String emailAddress;

	Person(String name, String address, String phoneNumber, String emailAddress) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	Person() {
	}

	public String toString() {
		return "Class Person" + " Name: " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Student extends Person {
	public static int FRESHMAN = 1;
	public static int SOPHOMORE = 2;
	public static int JUNIOR = 3;
	public static int SENIOR = 4;

	Student() {
	}

	@Override
	public String toString() {
		return "Class Student" + " Name: " + getName();
	}

}

class Employee extends Person {
	protected String office;
	protected double salary;
	protected java.util.Date dateHired;

	Employee(String office, double salary) {
		this.office = office;
		this.salary = salary;
		this.dateHired = new java.util.Date();

	}

	@Override
	public String toString() {
		return "Class Employee" + " Name: " + getName();
	}

	Employee() {
	}

}

class Faculty extends Employee {
	public static int LECTURER = 1;
	public static int ASSISTANT_PROFESSOR = 2;
	public static int ASSOCIATE_PROFESSOR = 3;
	public static int PROFESSOR = 4;
	protected double officeHours;
	protected int rank;

	Faculty(double officeHours, int rank) {
		this.officeHours = officeHours;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Class Faculty" + " Name: " + getName();
	}

	Faculty() {
	}
}

class Staff extends Employee {
	protected String title;

	Staff(double salary, String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff's title is: " + title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	Staff() {
	}
}

public class TestPerson {

	public static void main(String[] args) {
		Person p = new Person("Marko", "Doboj", "123456", "nesto@gmail.com");
		System.out.println(p.toString());
		Student s = new Student();
		s.setName("Janko");
		System.out.println(s.toString());
		Employee e = new Employee();
		e.setName("Pero");
		System.out.println(e.toString());
		Faculty f = new Faculty();
		f.setName("PMF");
		System.out.println(f.toString());
		Staff st = new Staff();
		st.setTitle("title");
		System.out.println(st.toString());
	}

}
