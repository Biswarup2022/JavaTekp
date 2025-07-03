package scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DefinitionSelectQuery
{
	public static void main(String[] args) throws Throwable
	{
		/**
		 * Step 1 = Load /or/ Register the Database driver
		 * for manual - show databases;
		 * use database_name;
		 */
		Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			/**
			 * Step 2 = Connect to Database
			 * To establish the connection we need to pass the Syntax of Url of Database, Username, Password
			 * use database_name;
			 * Syntax of url = jdbc:database_name://port number/table_name, username of database, password
			 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				System.out.println("====Connection Established====");
				
			/**
			* Step 3 = Create SQL Statement
			 * It"ll return the value in form of Statement interface
			 * By using the Statement reference variable we'll pass the SQL Query
			 */
			Statement stat = conn.createStatement();
			
			/**
			 * Above Three Steps will be constant to establish the connection to database
			 * 
			 * Step 4 = Execute Select Query and Get Result
			 * in this step we'll execute as per the requirement, here we'll decide whether we have to crate/select/insert data from table
			 * There are 2 types of Query i) Select Query [executeQuery()]    ii) Non-Select Query [executeUpdate()]
			 */
			ResultSet resultSet = stat.executeQuery("select * from projects");
				while(resultSet.next())
				{
					System.out.println(resultSet.getString(1));
				}
				
			/**
			 * Step 5 = Close the connection to the database
			 * It is important to close the connection everytime otherwise it can crash the database
			 * If the code is not executing properly /OR/ if we are giving any wrong SQL Query then the excution will be stopped without removing the connection
			 * That can be harmful for the database
			 * So that we'll write the code from step1 to step4 into try-catch block
			 * and step5 should be written in finally block
			 */
			conn.close();
	}

}
