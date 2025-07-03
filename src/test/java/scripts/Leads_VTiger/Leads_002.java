package scripts.Leads_VTiger;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import VTiger.ObjectRepo.CreateNewLeads;
import VTiger.ObjectRepo.LeadsPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import VTiger.ObjectRepo.VTiger_LoginPage;
import genericUtility.FilesUtility.ExcelUtility;
import genericUtility.FilesUtility.JavaUtility;
import genericUtility.FilesUtility.PropertiesUtility;
import genericUtility.FilesUtility.WebDriverUtility;

public class Leads_002
{
	public static void main(String[] args) throws Throwable
	{
//		Random r = new Random();
//		int random = r.nextInt(10);
		
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
//		Sheet sh = wb.getSheet("Leads");
//		Row leadsRow = sh.getRow(5);
//		Cell c = leadsRow.getCell(1);
//		String leadsFirstName = c.getStringCellValue();
//		Cell cL = leadsRow.getCell(2);
//		String leadsLastName = cL.getStringCellValue();
//		Cell cC = leadsRow.getCell(3);
//		String leadsCompanyName = cC.getStringCellValue();
//		Cell cT = leadsRow.getCell(4);
//		String leadsTitleName = cT.getStringCellValue();
//		Cell cM = leadsRow.getCell(5);
//		String leadsMob = cM.getStringCellValue();
//		Cell cE = leadsRow.getCell(6);
//		String leadsEmail = cE.getStringCellValue();
		
		ExcelUtility eLib = new ExcelUtility();
		String leadsFirstName = eLib.getDataFromExcelFile("Leads", 5, 1);
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 5, 2)+random;
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 5, 3)+random;
		String leadsTitleName = eLib.getDataFromExcelFile("Leads", 5, 4);
		String leadsMob = eLib.getDataFromExcelFile("Leads", 5, 5);
		String leadsEmail = eLib.getDataFromExcelFile("Leads", 5, 6);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();	
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.implicitlyWaitAndMX(driver);
		
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
		VTiger_LoginPage loginPage = new VTiger_LoginPage(driver);
		loginPage.LoginToApp(username, password);
		
//		driver.findElement(By.linkText("Leads")).click();
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getLeadsOption().click();
		
//		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		LeadsPlusIcon plusIcon = new LeadsPlusIcon(driver);
		plusIcon.clickOnLeadsPlus();
		
		WebElement firstNameDD = driver.findElement(By.name("salutationtype"));
//		Select mrSel = new Select(firstNameDD);
//		mrSel.selectByValue("Mr.");
		wLib.getSelectValueByValue(firstNameDD, "Mr.");
		
//		driver.findElement(By.name("firstname")).sendKeys(leadsFirstName);
//		driver.findElement(By.name("lastname")).sendKeys(leadsLastName);
//		driver.findElement(By.name("company")).sendKeys(leadsCompanyName);
//		driver.findElement(By.name("designation")).sendKeys(leadsTitleName);
//		driver.findElement(By.name("mobile")).sendKeys(leadsMob);
//		driver.findElement(By.name("email")).sendKeys(leadsEmail);
//		driver.findElement(By.name("button")).click();
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsFirstName, leadsLastName, leadsCompanyName, leadsTitleName, leadsMob, leadsEmail);
		
		String actMob = driver.findElement(By.id("dtlview_Mobile")).getText();
		if(actMob.equals(leadsMob))
		{
			System.out.println("Mobile Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Mobile Number Validation ====> FAIL");	
		}
		
		String actEmail = driver.findElement(By.id("dtlview_Email")).getText();
		if(actEmail.contains(leadsEmail))
		{
			System.out.println("Email Validation ====> PASS");
		}
		else
		{
			System.out.println("Email Validation ====> FAIL");	
		}
		
		driver.close();
	}

}
