package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {
	
	private  final Connection myCon; 
	private final Statement myStat;

	public DatabaseService() throws SQLException {
		this.myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/fabiancompany","root",""); 
		this.myStat = this.myCon.createStatement();
	}
	
	public ResultSet queryDB(String query) throws SQLException {
		
		return this.myStat.executeQuery(query);
		
//		Abstufungen machen für die anderen MYSQL Queries
	}
	
}
