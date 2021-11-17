package modelLayer;

public class Employee  extends Person{
	private Employee manager;
	private double salary;
	private String specialization;
	
	public Employee(int id, String firstName, String lastName, String phoneNumber, String email, Employee manager, double salary, String specialization, String note) {
		super(id,firstName,lastName,phoneNumber,email,note);
		this.manager = manager;
		this.salary = salary;
		this.specialization = specialization;
	}
	public Employee(String firstName, String lastName, String phoneNumber, String email, Employee manager, double salary, String specialization, String note) {
		super(firstName,lastName,phoneNumber,email,note);
		this.manager = manager;
		this.salary = salary;
		this.specialization = specialization;
	}
	public Employee() {
	}
	public Employee(int id) {
		super(id);
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
}
