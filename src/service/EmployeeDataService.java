package service;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Employee;

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
	

	
	
	
	
	

}
