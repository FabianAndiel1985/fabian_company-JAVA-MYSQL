package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Employee;
import view.EmployeeTable;

public class EmployeeDataService {
	
	
	
	public List<Employee> sortEmployeesByLastName(List<Employee> employeeList) {	
		List<Employee> tmpList = new ArrayList<Employee>();
		tmpList.addAll(employeeList);
		tmpList.sort(Comparator.comparing(e -> e.getLastname()));
		
		return tmpList;
	}
	
	
	public Path createFile(String targetFileName) throws IOException,FileAlreadyExistsException {
			
			String currentWorkingDirectory = System.getProperty("user.dir");
			
			Path targetFile = Paths.get(currentWorkingDirectory,targetFileName);
			
			return targetFile;
		}
	
	
	public List<Employee> sortEmployeesBySalary( List<Employee> employees ) {
		
		List<Employee> tmpList = new ArrayList<Employee>();
		tmpList.addAll(employees);
		tmpList.sort(Comparator.comparingDouble(e ->  e.getSalary()));
		
		return tmpList;
	}
	
	
	
	public EmployeeTable createEmployeeTable(List<Employee> employeeList) {
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
	
	
	public void writeToFile(List<Employee> sortedEmployeeList, Path savedFileTargetPath  ) throws IOException, FileAlreadyExistsException  {

		if(sortedEmployeeList != null) {
		
			Files.createFile(savedFileTargetPath);
			
			FileOutputStream output = new FileOutputStream(savedFileTargetPath.toString());
			
			ObjectOutputStream objOutput = new ObjectOutputStream(output);
			
			for(Employee e : sortedEmployeeList) {
				objOutput.writeObject(e);	
			}
			
			output.close();
			
			objOutput.close();
		}
		
		else {
			System.out.println("please get the employees data initially");
		}
		
	}
	
	
	
}
