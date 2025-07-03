package scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class GenerateDatabase
{

	public static void main(String[] args) throws Throwable
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcode", "root", "root");
		System.out.println("====Connection Established====");
		Statement stat = conn.createStatement();
//---------------------------------------------------------------------------------------------------------------------
		/**
		 * To Select all the data from a table of a database
		 */	
		ResultSet rs = stat.executeQuery("select * from emp");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" \t"+ rs.getString(2)+" \t "+ rs.getString(3)+" \t "+rs.getString(4)+" \t "+rs.getString(5));
		}
		conn.close();
		
//------------------------------------------------------------------------------------------------------------------
		        // To Create Database through Automation
		
		/* String createDatabaseQuery = "CREATE DATABASE teachers";
		state.executeUpdate(createDatabaseQuery);                
		System.out.println("Database is created successfully");
		conn.close(); */
				
//------------------------------------------------------------------------------------------------------------------
		        // To Create Table through Automation
				
		/* String createTable = "CREATE TABLE teachers("
		+ "id INT AUTO_INCREMENT PRIMARY KEY, "
		+ "username VARCHAR(255) NOT NULL, "
		+ "email VARCHAR(255) NOT NULL, "
		+ "age INT)";
		state.executeUpdate(createTable);                        
		
		System.out.println("Table 'teachers' created successfully in the database.");
		conn.close(); */
		
//-----------------------------------------------------------------------------------------------------------------
		       // To Insert data through Automation
		
		/* int result = state.executeUpdate("insert into teachers(username,email,age)value('Kanisk_01','kanisk@gmail.com','26'),('Ashok_02','ashok@gmail.com','30')");
		System.out.println(result);
		conn.close(); */
		
//------------------------------------------------------------------------------------------------------------------
		      // To print All data through Automation
		/* ResultSet res = state.executeQuery("select * from teachers");
		while(res.next())
		{
		System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
		}                                                         
		conn.close(); */
		
//------------------------------------------------------------------------------------------------------------------
		    // To print a particular data through Automation
		
		/* ResultSet res = state.executeQuery("select * from teachers where ");
		res.next();
		System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
		conn.close(); */
		
	}

}
