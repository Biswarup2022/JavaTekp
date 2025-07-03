package scripts.Contacts_VTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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
import genericUtility.FilesUtility.ExcelUtility;
import genericUtility.FilesUtility.PropertiesUtility;
import genericUtility.FilesUtility.WebDriverUtility;

public class Con_002
{
	public static void main(String[] args) throws Throwable
	{
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
//		Row r = sh.getRow(5);
//		Cell c = r.getCell(1);
//		Cell cE = r.getCell(2);
//		Cell cM = r.getCell(3);
//		Cell cMailC = r.getCell(4);
		
		ExcelUtility eLib = new ExcelUtility();		
		String conLastName = eLib.getDataFromExcelFile("Contacts", 5, 1);		
		String conEmail = eLib.getDataFromExcelFile("Contacts", 5, 2);
		String conMob = eLib.getDataFromExcelFile("Contacts", 5, 3);
		String conMailCity = eLib.getDataFromExcelFile("Contacts", 5, 4);
		
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
//		driver.findElement(By.name("email")).sendKeys(conEmail);
//		driver.findElement(By.name("mobile")).sendKeys(conMob);
//		driver.findElement(By.name("mailingcity")).sendKeys(conMailCity);
//		driver.findElement(By.name("button")).click();
		CreateNewContact contact = new CreateNewContact(driver);
		contact.createNewContact(conLastName, conEmail, conMob, conMailCity);
		
		String actEmail = driver.findElement(By.id("mouseArea_Email")).getText();
		if(actEmail.contains(conEmail))
		{
			System.out.println("Email Validation ====> PASS");
		}
		else
		{
			System.out.println("Email Validation ====> FAIL");	
		}
		
		String actMob = driver.findElement(By.id("dtlview_Mobile")).getText();
		if(actMob.equals(conMob))
		{
			System.out.println("Mobile Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Mobile Number Validation ====> FAIL");			
		}
		
		homePage.SignOutOperation(driver);
		
		driver.close();
	}
}
