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
	
	
	
	public EmployeeTable extracted(List<Employee> employeeList) {
		String[] columnNames = {"id","firstname","lastname","department","salary"};
		
		String[][] rowData = new String[employeeList.size()][columnNames.length];

		for (int i = 0; i < rowData.length; i++) {
			rowData[i][0] = Integer.toString(employeeList.get(i).getId());
			rowData[i][1] = employeeList.get(i).getFirstname();
			rowData[i][2] = employeeList.get(i).getLastname();
			rowData[i][3] = employeeList.get(i).getDepartment();
			rowData[i][4] = Double.toString(employeeList.get(i).getSalary());
		}	
		
		EmployeeTable table = new EmployeeTable(rowData, columnNames);
		return table;
	}
	
	
	
	
}
