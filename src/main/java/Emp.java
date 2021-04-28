
public class Emp {
	int id;
	int age;
	String name;
	Salare salare;
	
	public Salare getSalare() {
		return salare;
	}
	public void setSalare(Salare salare) {
		this.salare = salare;
	}
	public Emp(int id, int age, String name, Salare salare) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.salare = salare;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Emp(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	

}
