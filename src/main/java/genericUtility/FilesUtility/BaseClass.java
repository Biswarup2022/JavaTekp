package genericUtility.FilesUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import VTiger.ObjectRepo.VTiger_HomePage;
import VTiger.ObjectRepo.VTiger_LoginPage;

public class BaseClass
{
		public DatabaseUtility dLib = new DatabaseUtility();
		public PropertiesUtility pLib = new PropertiesUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public JsonUtility jsLib = new JsonUtility();
		public WebDriver driver = null;
	
	@BeforeSuite(alwaysRun = true)
	public void getConnectionToDatabase()
	{
		System.out.println("Database Connection Established Successfully");
	}
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable
	{
		String Browser = pLib.getDataFromPropertiesFile("browser");
		String URL = pLib.getDataFromPropertiesFile("url");
		
		if(Browser.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if (Browser.equals("firefox"))
		{
		driver = new FirefoxDriver();
		}
		else if (Browser.equals("edge"))
		{
		driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		wLib.implicitlyWaitAndMX(driver);
		wLib.urlToVTiger(driver, URL);
		System.out.println("Browser Launched Successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginIntoVTiger() throws Throwable
	{
		String USERNAME = pLib.getDataFromPropertiesFile("username");
		String PASSWORD = pLib.getDataFromPropertiesFile("password");
		VTiger_LoginPage login = new VTiger_LoginPage(driver);
		login.LoginToApp(USERNAME, PASSWORD);
		System.out.println("Login Into VTiger Successfully ");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromVTiger()
	{
		VTiger_HomePage home = new VTiger_HomePage(driver);
		home.SignOutOperation(driver);
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser()
	{
		driver.quit();
		System.out.println("Browser Closed Successfully");
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeConnectionToDatabase()
	{
		System.out.println("Database Connection Closed Successfully");
	}
	
}
