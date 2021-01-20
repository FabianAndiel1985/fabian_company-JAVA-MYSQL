package main;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import model.Employee;
import service.DatabaseService;
import view.EmployeeTable;
import view.UI;

public class Controller {
	
	private DatabaseService dbService; 
	private List<Employee> employeeList;
	private UI view;

	public Controller() throws SQLException  {
		this.view =new UI();
		this.initUI();
		this.dbService = new DatabaseService();
		this.employeeList = dbService.getEmployees();
		
	}

	
	private void initUI() {
		this.initShowEmployeesBtn();
		this.initButton2();
	}
	
	private void initShowEmployeesBtn() {
		this.view.getShowEmployeesBtn().addActionListener(
				e -> {
					this.createEmployeeTable();
				});
	}
	
	
	
	private void createEmployeeTable() {
		
		if (this.view.getEmployeeTable() != null) {
			this.view.remove(this.view.getEmployeeTable());
		}
		
		String[] columnNames = {"id","firstname","lastname","department","salary"};
		
		String[][] rowData = new String[this.employeeList.size()][columnNames.length];

		for (int i = 0; i < rowData.length; i++) {
			rowData[i][0] = Integer.toString(this.employeeList.get(i).getId());
			rowData[i][1] = this.employeeList.get(i).getFirstname();
			rowData[i][2] = this.employeeList.get(i).getLastname();
			rowData[i][3] = this.employeeList.get(i).getDepartment();
			rowData[i][4] = Double.toString(this.employeeList.get(i).getSalary());
		}	
		
		EmployeeTable table = new EmployeeTable(rowData, columnNames);
		
		this.view.setEmployeeTable(table);
		
		this.view.add(table);

		this.view.setVisible(true);
			
	}
	
	
	

	private void initButton2() {
			this.view.getButton2().addActionListener(
		e -> {
			this.sortEmployeesByLastName();
			this.createEmployeeTable();
		});
		
	}


	private void sortEmployeesByLastName() {	
		this.employeeList.sort(Comparator.comparing(e -> e.getLastname()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
