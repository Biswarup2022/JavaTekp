package genericUtility.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mysql.jdbc.Driver;

import VTiger.ObjectRepo.VTiger_HomePage;
import VTiger.ObjectRepo.VTiger_LoginPage;
import genericUtility.FilesUtility.PropertiesUtility;

public class BaseClassPractice {
	
	public static WebDriver sdriver = null;
	public Connection conn;
	public WebDriver driver;
	public PropertiesUtility pData = new PropertiesUtility();
	VTiger_LoginPage LPage = new VTiger_LoginPage(driver);
	VTiger_HomePage hPage = new VTiger_HomePage(driver);		
	

		@BeforeSuite
		public void getConnectionToDB() throws Throwable {
			System.out.println("<======= DATABASE CONNECTION ESTABLISHED =======>");
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tekp", "root", "root");
			} catch (SQLException e) {		}
			
		}
		
		@BeforeClass
		public void launchTheBrowser() throws Throwable {
			System.out.println("<======= BROWSER LAUNCHED =======>");
//			String br = pData.getDataFromPropertiesFile("browser");
			driver = new ChromeDriver();
			String Url = pData.getDataFromPropertiesFile("url");
			driver.get(Url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		
		@BeforeMethod
		public void loginToApplication() throws Throwable {
			System.out.println("<======= LOGGED IN SUCCESFULLY =======>");
			String userName = pData.getDataFromPropertiesFile("username");
			String passWord = pData.getDataFromPropertiesFile("password");
			LPage.LoginToApp(userName, passWord);
		}

		@BeforeTest
		public void getTest() {
			System.out.println("<======= ON TEST STARTED =======>");
		}
		
		@AfterMethod
		public void logoutFromApplication() {
			System.out.println("<======= LOGGED OUT SUCCESFULLY =======>");
			
			hPage.SignOutOperation(driver);
		}
		
		@AfterClass
		public void closeTheBrowser() {
			System.out.println("<======= BROWSER CLOSED =======>");
			
			driver.quit();
		}
		
		@AfterTest
		public void setTest() {
			System.out.println("<======= ON TEST FINISHES =======>");
		}
		
		@AfterSuite
		public void closeConnectionToDB() {
			System.out.println("<======= DATABASE CONNECTION CLOSED =======>");
			
			try {
				conn.close();
			} catch (SQLException e) {	}
		}
		
}
