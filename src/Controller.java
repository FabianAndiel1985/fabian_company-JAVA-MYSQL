

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

	public Controller() throws SQLException  {
		this.view =new UI();
		this.initUI();
		this.dbService = new DatabaseService();
		this.employeeList = dbService.getEmployees();
		
	}
	
	private void writeToFile() throws IOException, FileAlreadyExistsException  {
		
		Path targetPath = this.createFile("save.ser");
		
		FileOutputStream output = new FileOutputStream(targetPath.toString());
		
		ObjectOutputStream objOutput = new ObjectOutputStream(output);
		
		for(Employee e : this.employeeList) {
			objOutput.writeObject(e);	
		}
	}
	


	private Path createFile(String targetFileName) throws IOException,FileAlreadyExistsException {
			
			String currentWorkingDirectory = System.getProperty("user.dir");
		
			Path targetFile = Paths.get(currentWorkingDirectory,targetFileName);
			
			Files.createFile(targetFile);
			
			return targetFile;
		}

	
	private void initUI() {
		this.initShowEmployeesBtn();
		this.initSortByLastNameBtn();
		this.initWriteEmployeesToFile();
	}
	
	private void initShowEmployeesBtn() {
		this.view.getShowEmployeesBtn().addActionListener(
				e -> {
					this.createEmployeeTable(this.employeeList);
				});
	}
	
	
	private void initSortByLastNameBtn() {
		this.view.getSortEmployeesByLastNameBtn().addActionListener(
	e -> {
		List<Employee> sortedList = this.sortEmployeesByLastName(this.employeeList);
		this.createEmployeeTable(sortedList);
	});
	
}
	
	
	
	private void initWriteEmployeesToFile() {
		this.view.getWriteEmployeesToFile().addActionListener(
			e -> {
				try {
					this.writeToFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
