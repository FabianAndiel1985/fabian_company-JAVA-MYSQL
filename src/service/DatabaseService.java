package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import view.EmployeeTable;
import model.Employee;



public class DatabaseService {
	
	private  final Connection myCon; 
	private final Statement myStat;

	
	public DatabaseService() throws SQLException {
		this.myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/fabiancompany","root",""); 
		this.myStat = this.myCon.createStatement();
	}
	
	
	
	public List<Employee> getEmployees() throws SQLException {
		
		ResultSet res =  this.getWholeEmployeeData();
		
		List<Employee> list = new ArrayList<Employee>();
		while(res.next()) {
			Employee employee = new Employee();
			employee.setId(res.getInt("id"));
			employee.setFirstname(res.getString("firstname"));
			employee.setLastname(res.getString("lastname"));
			employee.setDepartment(res.getString("department"));
			employee.setLastname(res.getString("lastname"));
			employee.setSalary(res.getDouble("salary"));
			list.add(employee);
		}
		return list;
	}
	
	
	
	private ResultSet getWholeEmployeeData() throws SQLException {
		
		return this.myStat.executeQuery("select * from employees");

	}
	
	
	
	
	
	
	
	
}
