package scripts.Organisation_VTiger;

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

import VTiger.ObjectRepo.CreateNewOrg;
import VTiger.ObjectRepo.OrgPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import VTiger.ObjectRepo.VTiger_LoginPage;
import genericUtility.FilesUtility.ExcelUtility;
import genericUtility.FilesUtility.JavaUtility;
import genericUtility.FilesUtility.PropertiesUtility;
import genericUtility.FilesUtility.WebDriverUtility;

public class Org_003
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
//		Sheet sh = wb.getSheet("Organizations");
//		Row orgRow = sh.getRow(8);
//		Cell c = orgRow.getCell(1);
//		String orgName = c.getStringCellValue()+random;
//		Cell cE = orgRow.getCell(2);
//		String orgEmail = cE.getStringCellValue();
//		Cell cM = orgRow.getCell(3);
//		String orgPhone = cM.getStringCellValue();
//		Cell cS = orgRow.getCell(4);
//		String orgShippingCity = cS.getStringCellValue();
//		Cell cSh = orgRow.getCell(5);
//		String orgShippingState = cSh.getStringCellValue();
//		Cell cSc = orgRow.getCell(6);
//		String orgShippingCountry = cSc.getStringCellValue();
		
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.getDataFromExcelFile("Organizations", 8, 1)+random;
		String orgEmail = eLib.getDataFromExcelFile("Organizations", 8, 2);
		String orgPhone = eLib.getDataFromExcelFile("Organizations", 8, 3);
		String orgShippingCity = eLib.getDataFromExcelFile("Organizations", 8, 4);
		String orgShippingState = eLib.getDataFromExcelFile("Organizations", 8, 5);
		String orgShippingCountry = eLib.getDataFromExcelFile("Organizations", 8, 6);
		
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
		
//		driver.findElement(By.linkText("Organizations")).click();
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getOrganizationsOption().click();
		
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrgPlusIcon plusIcon = new OrgPlusIcon(driver);
		plusIcon.clickOnOrgPlus();
		
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		driver.findElement(By.name("email1")).sendKeys(orgEmail);
//		driver.findElement(By.name("phone")).sendKeys(orgPhone);
//		driver.findElement(By.name("ship_city")).sendKeys(orgShippingCity);
//		driver.findElement(By.name("ship_state")).sendKeys(orgShippingState);
//		driver.findElement(By.name("ship_country")).sendKeys(orgShippingCountry);
//		driver.findElement(By.name("button")).click();
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgEmail, orgPhone, orgShippingCity, orgShippingState, orgShippingCountry);
		
		String actOrgShippingCity = driver.findElement(By.id("dtlview_Shipping City")).getText();
		if(actOrgShippingCity.contains(orgShippingCity))
		{
			System.out.println("Organization Shipping City Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Shipping City Validation ====> FAIL");	
		}
		
		String actOrgShippingState = driver.findElement(By.id("dtlview_Shipping State")).getText();
		if(actOrgShippingState.contains(orgShippingState))
		{
			System.out.println("Organization Shipping State Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Shipping State Validation ====> FAIL");	
		}
		
		String actOrgShippingCountry = driver.findElement(By.id("dtlview_Shipping Country")).getText();
		if(actOrgShippingCountry.contains(orgShippingCountry))
		{
			System.out.println("Organization Shipping Country Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Shipping Country Validation ====> FAIL");	
		}
		
		driver.close();
	}

}
