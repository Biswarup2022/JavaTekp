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

public class Leads_003
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
//		Row leadsRow = sh.getRow(8);
//		Cell c = leadsRow.getCell(1);		
//		String leadsLastName = c.getStringCellValue();
//		Cell cC = leadsRow.getCell(2);
//		String leadsCompanyName = cC.getStringCellValue();
//		Cell cN = leadsRow.getCell(4);
//		String leadsEmpNo = cN.getStringCellValue();
//		Cell cCity = leadsRow.getCell(5);
//		String leadsCity = cCity.getStringCellValue();
//		Cell cCountry = leadsRow.getCell(6);
//		String leadsCountry = cCountry.getStringCellValue();
//		Cell cState = leadsRow.getCell(7);
//		String leadsState = cState.getStringCellValue();
		
		ExcelUtility eLib = new ExcelUtility();
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 8, 1)+random;
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 8, 2)+random;
		String leadsSource = eLib.getDataFromExcelFile("Leads", 8, 3);
		String leadsEmpNo = eLib.getDataFromExcelFile("Leads", 8, 4);
		String leadsCity = eLib.getDataFromExcelFile("Leads", 8, 5);
		String leadsCountry = eLib.getDataFromExcelFile("Leads", 8, 6);
		String leadsState = eLib.getDataFromExcelFile("Leads", 8, 7);
		
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
		
		driver.findElement(By.linkText("Leads")).click();
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getLeadsOption().click();
		
//		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		LeadsPlusIcon plusIcon = new LeadsPlusIcon(driver);
		plusIcon.clickOnLeadsPlus();
		
//		Select sel = new Select(leadSourceDD);
//		sel.selectByValue("Partner");
		WebElement leadSourceDD = driver.findElement(By.name("leadsource"));
		wLib.getSelectValueByValue(leadSourceDD, leadsSource);
		
//		driver.findElement(By.name("lastname")).sendKeys(leadsLastName);
//		driver.findElement(By.name("company")).sendKeys(leadsCompanyName);
//		driver.findElement(By.name("noofemployees")).sendKeys(leadsEmpNo);
//		driver.findElement(By.name("city")).sendKeys(leadsCity);
//		driver.findElement(By.name("country")).sendKeys(leadsCountry);
//		driver.findElement(By.name("state")).sendKeys(leadsState);
//		driver.findElement(By.name("button")).click();
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsLastName, leadsCompanyName, leadsSource, leadsEmpNo, leadsCity, leadsCountry, leadsState);
		
		String actLeadSource = driver.findElement(By.id("dtlview_Lead Source")).getText();
		if(actLeadSource.contains("Partner"))
		{
			System.out.println("Lead Source Validation ====> PASS");
			}
			else
			{
				System.out.println("Lead Source Validation ====> FAIL");	
			}
		
		String actEmpNo = driver.findElement(By.id("dtlview_No Of Employees")).getText();
		if(actEmpNo.contains(leadsEmpNo))
		{
			System.out.println("Employee Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Employee Number Validation ====> FAIL");	
		}
		
		String actCountry = driver.findElement(By.id("dtlview_Country")).getText();
		if(actCountry.contains(leadsCountry))
		{
			System.out.println("Country Validation ====> PASS");
		}
		else
		{
			System.out.println("Country Validation ====> FAIL");	
		}
		
		driver.close();
	}
}
