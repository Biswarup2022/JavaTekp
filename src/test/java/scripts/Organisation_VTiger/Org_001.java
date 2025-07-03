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

public class Org_001
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
//		Row orgRow = sh.getRow(2);
//		Cell c = orgRow.getCell(1);
//		String orgName = c.getStringCellValue()+random;
//		Cell cT = orgRow.getCell(2);
//		String orgWebsite = cT.getStringCellValue();
//		Cell cD = orgRow.getCell(3);
//		String orgOwnership = cD.getStringCellValue();
		
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.getDataFromExcelFile("Organizations", 2, 1)+random;
		String orgWebsite = eLib.getDataFromExcelFile("Organizations", 2, 2);
		String orgOwnership = eLib.getDataFromExcelFile("Organizations", 2, 3);
				
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
//		driver.findElement(By.name("website")).sendKeys(orgWebsite);
//		driver.findElement(By.name("ownership")).sendKeys(orgOwnership);
//		driver.findElement(By.name("button")).click();
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgWebsite, orgOwnership);
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println("Organization Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Name Validation ====> FAIL");	
		}
		
		String actOrgWebsite = driver.findElement(By.id("dtlview_Website")).getText();
		if(actOrgWebsite.contains(orgWebsite))
		{
			System.out.println("Website Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Website Name Validation ====> FAIL");	
		}
		
		String actOrgOwnership = driver.findElement(By.id("dtlview_Ownership")).getText();
		if(actOrgOwnership.contains(orgOwnership))
		{
			System.out.println("Organization Ownership Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Ownership Name Validation ====> FAIL");	
		}
		
		driver.close();
	}

}
