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

public class Leads_001
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
//		Row leadsRow = sh.getRow(2);
//		Cell c = leadsRow.getCell(1);
//		String leadsFirstName = c.getStringCellValue();
//		Cell cL = leadsRow.getCell(2);
//		String leadsLastName = cL.getStringCellValue()+random;
//		Cell cC = leadsRow.getCell(3);
//		String leadsCompanyName = cC.getStringCellValue()+random;
		
		ExcelUtility eLib = new ExcelUtility();
		String leadsFirstName = eLib.getDataFromExcelFile("Leads", 2, 1);
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 2, 2)+random;
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 2, 3)+random;
		
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
//		driver.findElement(By.name("button")).click();
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsFirstName, leadsLastName, leadsCompanyName);
		
		String actFirstName = driver.findElement(By.id("dtlview_First Name")).getText();
		if(actFirstName.contains(leadsFirstName))
		{
			System.out.println("First Name Validation ====> PASS");
		}
		else
		{
			System.out.println("First Name Validation ====> FAIL");	
		}
		
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.contains(leadsLastName))
		{
			System.out.println("Last Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Last Name Validation ====> FAIL");	
		}
		
		String actCompanyName = driver.findElement(By.id("dtlview_Company")).getText();
		if(actCompanyName.equals(leadsCompanyName))
		{
			System.out.println("Company Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Company Name Validation ====> FAIL");	
		}

		driver.close();
	}

}
