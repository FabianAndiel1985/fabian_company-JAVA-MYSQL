package main;

import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
					this.readEmployeesFromFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			});
	}
	
	
	private void readEmployeesFromFile() throws IOException {
				
				Employee emp = null;
		       FileInputStream fileInputStream=null;
		       boolean cont = true; 
		       List<Employee> employees = new ArrayList<Employee>();
				fileInputStream = new FileInputStream(this.savedFileTargetPath.toString());
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				
				while(cont) {
					try {
						emp = (Employee) objectInputStream.readObject();
						employees.add(emp);
					} catch (EOFException e) {
						break;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
				}
				fileInputStream.close();
				
				objectInputStream.close();

		       System.out.println(employees);
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
	
	
//	
//private void writeToFile() throws IOException, FileAlreadyExistsException  {
////		
//		if(this.sortedEmployeeList != null) {
//		
//			Files.createFile(this.savedFileTargetPath);
//			
//			FileOutputStream output = new FileOutputStream(this.savedFileTargetPath.toString());
//			
//			ObjectOutputStream objOutput = new ObjectOutputStream(output);
//			
//			for(Employee e : this.sortedEmployeeList) {
//				objOutput.writeObject(e);	
//			}
//			
//			output.close();
//			
//			objOutput.close();
//		}
//		
//		else {
//			System.out.println("please get the employees data initially");
//		}
//		
//	}
	
	
	

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
