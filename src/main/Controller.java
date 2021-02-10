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
import view.EmployeeTable;
import view.UI;

public class Controller {
	
	private DatabaseService dbService; 
	private List<Employee> employeeList;
	private UI view;
	private Path savedFileTargetPath;
	private List<Employee> sortedEmployeeList;

	public Controller() throws SQLException, NullPointerException  {
		this.view =new UI();
		this.initUI();
		this.dbService = new DatabaseService();
		this.employeeList = dbService.getEmployees();
		
//		MACHEN  DASS ER NUR DAS FILE ERZEUGT WENN ES EXISTIERT
		
		try {
			this.savedFileTargetPath = this.createFile("save.ser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	
	private void writeToFile() throws IOException, FileAlreadyExistsException  {
		
		Files.createFile(this.savedFileTargetPath);
		
		FileOutputStream output = new FileOutputStream(this.savedFileTargetPath.toString());
		
		ObjectOutputStream objOutput = new ObjectOutputStream(output);
		
		for(Employee e : this.sortedEmployeeList) {
			objOutput.writeObject(e);	
		}
		
		objOutput.close();
	}
	


	private Path createFile(String targetFileName) throws IOException,FileAlreadyExistsException {
			
			String currentWorkingDirectory = System.getProperty("user.dir");
			
			System.out.println(currentWorkingDirectory);
		
			Path targetFile = Paths.get(currentWorkingDirectory,targetFileName);
			
			return targetFile;
		}


	
	private void initSortEmployeesBySalary() {
	
		this.view.getSortEmployeesBySalaryBtn().addActionListener(
	e -> {
		this.sortedEmployeeList= this.sortEmployeesBySalary(this.employeeList);
		this.createEmployeeTable(this.sortedEmployeeList);
	});
	}
	
	
	private List<Employee> sortEmployeesBySalary( List<Employee> employees ) {
		
		List<Employee> tmpList = new ArrayList<Employee>();
		tmpList.addAll(employeeList);
		tmpList.sort(Comparator.comparingDouble(e ->  e.getSalary()));
		
		return tmpList;
}
	
	
	private void initShowEmployeesBtn() {
		this.view.getShowEmployeesBtn().addActionListener(
				e -> {
					this.sortedEmployeeList = this.employeeList;
					this.createEmployeeTable(this.sortedEmployeeList);
				});
	}
	
	
	
	private void initSortByLastNameBtn() {
		this.view.getSortEmployeesByLastNameBtn().addActionListener(
	e -> {
		this.sortedEmployeeList = this.sortEmployeesByLastName(this.employeeList);
		this.createEmployeeTable(this.sortedEmployeeList);
	});
	
}
	

	private void initReadEmployeesFromFile() {
		this.view.getReadEmployeesFromFile().addActionListener(
			e -> {
				try {
					this.readEmployeesFromFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
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
				
				objectInputStream.close();

		       System.out.println(employees);
		   }
		 

	
	

	private void initWriteEmployeesToFile() {
		this.view.getWriteEmployeesToFile().addActionListener(
			e -> {
				try {
					this.writeToFile();
				} 
				
				catch (FileAlreadyExistsException e1) {
					
		            try {
						Files.deleteIfExists(Paths.get(this.savedFileTargetPath.toString()));
						this.writeToFile();
						
					} catch (IOException e2) {
						
						e2.printStackTrace();
					} 
					
				}
				
				catch (IOException e3) {
						
						e3.printStackTrace();
					} 
			});
	}
	
	

	private void createEmployeeTable(List<Employee> employeeList) {
		
		if (this.view.getEmployeeTable() != null) {
			this.view.remove(this.view.getEmployeeTable());
		}
		
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
		
		this.view.setEmployeeTable(table);
		
		this.view.add(table);

		this.view.setVisible(true);
			
	}
	
	
	private List<Employee> sortEmployeesByLastName(List<Employee> employeeList) {	
		List<Employee> tmpList = new ArrayList<Employee>();
		tmpList.addAll(employeeList);
		tmpList.sort(Comparator.comparing(e -> e.getLastname()));
		
		return tmpList;
	}
	
	
}
