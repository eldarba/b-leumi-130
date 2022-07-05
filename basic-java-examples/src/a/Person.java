package a;

public class Person {

	private int id;
	private String name;
	private int age;

	static {
		System.out.println("Person class loaded");
	}

	{
		System.out.println("person created");
	}

	public Person() {
		System.out.println("CTOR 1");
	}

	public Person(int id, String name, int age) {
		super();
		System.out.println("CTOR 2");
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Person(int id) {
		super();
		System.out.println("CTOR 3");
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
