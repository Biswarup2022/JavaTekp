package genericUtility.FilesUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility
{
	Connection conn;
	
	public void getDBConnection(String url, String username, String password) throws Throwable
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekp", "root", "root");			
			} catch (Exception e) { }
	}
	
	public ResultSet executeSelectQuery(String query) throws Throwable
	{
		ResultSet result = null;
		
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
			} catch (Exception e) { }
		return result;
	}
	
	public int executeNonSelectQuery (String query) throws Throwable
	{
		int result = 0;
		
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);			
			} catch (Exception e) { }
		return result;
	}
	
	public void closeDBConnection() throws Throwable
	{
		try {
			conn.close();
			}catch (Exception e) { }
	}
}
