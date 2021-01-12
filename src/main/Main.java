package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import service.DatabaseService;
import view.UI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	UI ui = new UI();
			
		try {
			DatabaseService databaseService = new DatabaseService();
			
			
			
			ui.getButton1().addActionListener(
				e -> {
					ResultSet res;
					try {
						res = databaseService.queryDB("select * from employees");
						
						while(res.next()) {
							System.out.println(res.getString("firstname"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			});
			
			
			
			
			
			
			
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 

}
