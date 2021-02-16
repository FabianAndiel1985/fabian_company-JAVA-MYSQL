package main;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import model.Employee;
import service.DatabaseService;
import service.EmployeeDataService;
import view.EmployeeTable;
import view.UI;

public class Controller {
	
	private EmployeeDataService employeeDataService;
	private DatabaseService dbService; 
	private List<Employee> employeeList;
	private UI view;
	private Path savedFileTargetPath;
	private List<Employee> sortedEmployeeList;


	public Controller() throws SQLException, NullPointerException  {
		this.view =new UI();
		this.initUI();
		this.employeeDataService = new EmployeeDataService();
		this.dbService = new DatabaseService();
		this.employeeList = dbService.getEmployees();
		
		try {
			this.savedFileTargetPath = this.employeeDataService.createFile("save.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private void initUI() {
		this.initShowEmployeesBtn();
		this.initSortByLastNameBtn();
		this.initWriteEmployeesToFile();
		this.initReadEmployeesFromFile();
		this.initSortEmployeesBySalary();
	}
	
	
	private void initSortEmployeesBySalary() {
	
		this.view.getSortEmployeesBySalaryBtn().addActionListener(
	e -> {
		this.sortedEmployeeList= this.employeeDataService.sortEmployeesBySalary(this.employeeList);
		this.createEmployeeTableInView(this.sortedEmployeeList);
	});
	}
	
	
	
	private void initShowEmployeesBtn() {
		this.view.getShowEmployeesBtn().addActionListener(
				e -> {
					this.sortedEmployeeList = this.employeeList;
					this.createEmployeeTableInView(this.sortedEmployeeList);
				});
	}
	
	
	
	private void initSortByLastNameBtn() {
		this.view.getSortEmployeesByLastNameBtn().addActionListener(
	e -> {
		this.sortedEmployeeList = this.employeeDataService.sortEmployeesByLastName(this.employeeList);
		this.createEmployeeTableInView(this.sortedEmployeeList);
	});
	
}
	
	
	private void initReadEmployeesFromFile() {
		this.view.getReadEmployeesFromFile().addActionListener(
			e -> {
				try {
					this.employeeDataService.readEmployeesFromFile(this.savedFileTargetPath);
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			});
	}
	
	
	
	
	private void initWriteEmployeesToFile() {
		this.view.getWriteEmployeesToFile().addActionListener(
			e -> {
				try {
					this.employeeDataService.writeToFile(this.sortedEmployeeList,this.savedFileTargetPath);
				} 
				
				catch (FileAlreadyExistsException e1) {
					
		            try {
						Files.deleteIfExists(Paths.get(this.savedFileTargetPath.toString()));
						this.employeeDataService.writeToFile(this.sortedEmployeeList,this.savedFileTargetPath);
						
					} catch (IOException e2) {
						
						e2.printStackTrace();
					} 
					
				}
				
				catch (IOException e3) {
						
						e3.printStackTrace();
					} 
			});
	}
	

	
	private void createEmployeeTableInView(List<Employee> employeeList) {
		
		if (this.view.getEmployeeTable() != null) {
			this.view.remove(this.view.getEmployeeTable());
		}
		
		EmployeeTable table = this.employeeDataService.createEmployeeTable(employeeList);
		
		this.view.setEmployeeTable(table);
		
		this.view.add(table);

		this.view.setVisible(true);
			
	}

		
}
