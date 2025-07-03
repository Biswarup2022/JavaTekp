package scripts.Contacts_VTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import genericUtility.FilesUtility.JavaUtility;
import genericUtility.FilesUtility.PropertiesUtility;
import genericUtility.FilesUtility.WebDriverUtility;

public class Con_004
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
//		Row r = sh.getRow(11);
//		Cell c = r.getCell(1);
//		Cell cE = r.getCell(2);
//		Cell cM = r.getCell(3);
//		Cell cMailC = r.getCell(4);
		
		ExcelUtility eLib = new ExcelUtility();
		String conLastName = eLib.getDataFromExcelFile("Contacts", 11, 1);
		String conEmail = eLib.getDataFromExcelFile("Contacts", 11, 2);
		String conMob = eLib.getDataFromExcelFile("Contacts", 11, 3);
		String conMailCity = eLib.getDataFromExcelFile("Contacts", 11, 4);
		
//		Calendar cal = Calendar.getInstance();
//		Date d = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String startDateStamp = sdf.format(d);		
//		Date da = cal.getTime();
//		cal.add(Calendar.DAY_OF_MONTH, 30);
//		String endDateStamp = sdf.format(da);
		JavaUtility jLib = new JavaUtility();
		String startDateStamp = jLib.getSystemDate();
		String endDateStamp = jLib.getRequiredDate(30);
		
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();	
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.implicitlyWaitAndMX(driver);
		driver.get(url);
		
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
//		driver.findElement(By.name("support_start_date")).clear();
//		driver.findElement(By.name("support_start_date")).sendKeys(startDateStamp);
//		driver.findElement(By.name("support_end_date")).clear();
//		driver.findElement(By.name("support_end_date")).sendKeys(endDateStamp);
//		driver.findElement(By.name("button")).click();
		CreateNewContact contact = new CreateNewContact(driver);
		contact.createNewContactWD(conLastName, conEmail, conMob, conMailCity, startDateStamp, endDateStamp);
		
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.contains(startDateStamp))
		{
			System.out.println("Start Date Validation ====> PASS");
		}
		else
		{
			System.out.println("Start Date Validation ====> FAIL");	
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.contains(endDateStamp))
		{
			System.out.println("End Date Validation ====> PASS");
		}
		else
		{
			System.out.println("End Date Validation ====> FAIL");	
		}
		
		homePage.SignOutOperation(driver);
		
		driver.close();
	}

}
