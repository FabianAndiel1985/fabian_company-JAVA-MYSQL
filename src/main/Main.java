package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Employee;
import service.DatabaseService;
import view.EmployeeTable;
import view.UI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Controller ct = new  Controller();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	 }
	}
	 


