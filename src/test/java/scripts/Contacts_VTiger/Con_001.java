package scripts.Contacts_VTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import VTiger.ObjectRepo.ContactPlusIcon;
import VTiger.ObjectRepo.CreateNewContact;
import VTiger.ObjectRepo.VTiger_HomePage;
import VTiger.ObjectRepo.VTiger_LoginPage;
import genericUtility.FilesUtility.BaseClass;
import genericUtility.FilesUtility.ExcelUtility;
import genericUtility.FilesUtility.JavaUtility;
import genericUtility.FilesUtility.PropertiesUtility;
import genericUtility.FilesUtility.WebDriverUtility;

public class Con_001 extends BaseClass
{
	/**
	 * Due to inheriting properties or actions from BaseClass
	 * Database(Connect, Disconnect), Browser-Launching, Login, Logout, Browser-Closing
	 * These actions or properties will be fetched from there directly
	 */
	public static void main(String[] args) throws Throwable
	{
//		Random r = new Random();
//		int random = r.nextInt(100);
		
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNumber(500);
		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TekPyramidCommonTC.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		String url = prop.getProperty("url");
//		String username = prop.getProperty("username");
//		String password = prop.getProperty("password");
		PropertiesUtility pLib = new PropertiesUtility();
		String url = pLib.getDataFromPropertiesFile("url");
		String username = pLib.getDataFromPropertiesFile("username");
		String password = pLib.getDataFromPropertiesFile("password");
		
		
		
//		FileInputStream fisx = new FileInputStream(".\\src\\test\\resources\\vTigerTekP.xlsx");
//		Workbook wb = WorkbookFactory.create(fisx);
//		Sheet sh = wb.getSheet("Contacts");
//		Row r = sh.getRow(2);
//		Cell c = r.getCell(1);
//		Cell cE = r.getCell(2);
//		Cell cM = r.getCell(3);
//		Cell cMailC = r.getCell(4);
		
		ExcelUtility eLib = new ExcelUtility();
		String conLastName = eLib.getDataFromExcelFile("Contacts", 2, 1)+random;
		String conTitle = eLib.getDataFromExcelFile("Contacts", 2, 2);
		String conDept = eLib.getDataFromExcelFile("Contacts", 2, 3);
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
		driver.get(url);
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.implicitlyWaitAndMX(driver);
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		VTiger_LoginPage loginPage = new VTiger_LoginPage(driver);
		loginPage.LoginToApp(username, password);
		
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getContactsOption().click();
		ContactPlusIcon plusIcon = new ContactPlusIcon(driver);
		plusIcon.clickOnContactPlusIcon();
			
//		driver.findElement(By.name("lastname")).sendKeys(conLastName);
//		driver.findElement(By.name("title")).sendKeys(conTitle);
//		driver.findElement(By.name("department")).sendKeys(conDept);
//		driver.findElement(By.name("button")).click();
		CreateNewContact contact = new CreateNewContact(driver);
		contact.createNewContact(conLastName, conTitle, conDept);
		
		String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actLastName.contains(conLastName))
		{
			System.out.println("Last Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Last Name Validation ====> FAIL");	
		}
		
		homePage.SignOutOperation(driver);
		
		driver.close();
	}
}
