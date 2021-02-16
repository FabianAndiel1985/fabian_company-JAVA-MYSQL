package main;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Controller ct = new  Controller();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			System.out.println("Is the XAMPP turned on? ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	}
	 


