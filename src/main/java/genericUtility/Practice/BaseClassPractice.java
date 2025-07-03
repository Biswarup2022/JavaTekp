package genericUtility.Practice;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClassPractice {
	
	public static WebDriver sdriver = null;

		@BeforeSuite
		public void getConnectionToDB() {
			System.out.println("<======= DATABASE CONNECTION ESTABLISHED =======>");
		}
		
		@BeforeTest
		public void getTest() {
			System.out.println("<======= ON TEST STARTED =======>");
		}
		
		@BeforeClass
		public void launchTheBrowser() {
			System.out.println("<======= BROWSER LAUNCHED =======>");
		}
		
		@BeforeMethod
		public void loginToApplication() {
			System.out.println("<======= LOGGED IN SUCCESFULLY =======>");
		}
		
		@AfterMethod
		public void logoutFromApplication() {
			System.out.println("<======= LOGGED OUT SUCCESFULLY =======>");
		}
		
		@AfterClass
		public void closeTheBrowser() {
			System.out.println("<======= BROWSER CLOSED =======>");
		}
		
		@AfterTest
		public void setTest() {
			System.out.println("<======= ON TEST FINISHES =======>");
		}
		
		@AfterSuite
		public void closeConnectionToDB() {
			System.out.println("<======= DATABASE CONNECTION CLOSED =======>");
		}
		
}
