package model;

public class Employee {
	
	private int id;
	private String firstname; 
	private String lastname; 
	private String department; 
	private double salary;
	
	public Employee() {
		
	};
	
	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", department=" + department + "]";
	}

	public Employee(int id, String firstname, String lastname, String department, double salary) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.salary = salary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	} 
	
	

	
	
}
