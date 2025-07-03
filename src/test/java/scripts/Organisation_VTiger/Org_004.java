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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import VTiger.ObjectRepo.CreateNewOrg;
import VTiger.ObjectRepo.OrgPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import VTiger.ObjectRepo.VTiger_LoginPage;
import genericUtility.FilesUtility.ExcelUtility;
import genericUtility.FilesUtility.JavaUtility;
import genericUtility.FilesUtility.PropertiesUtility;
import genericUtility.FilesUtility.WebDriverUtility;

public class Org_004
{
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
//		Sheet sh = wb.getSheet("Organizations");
//		Row orgRow = sh.getRow(11);
//		Cell c = orgRow.getCell(1);
//		String orgName = c.getStringCellValue()+random;
//		Cell cT = orgRow.getCell(2);
//		String orgWebsite = cT.getStringCellValue();
//		Cell cI = orgRow.getCell(3);
//		String orgIndustry = cI.getStringCellValue();
//		Cell cD = orgRow.getCell(4);
//		String orgOwnership = cD.getStringCellValue();
//		Cell cE = orgRow.getCell(5);
//		String orgEmp = cE.getStringCellValue();
		
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.getDataFromExcelFile("Organizations", 11, 1)+random;
		String orgWebsite = eLib.getDataFromExcelFile("Organizations", 11, 2);
		String orgIndustry = eLib.getDataFromExcelFile("Organizations", 11, 3);
		String orgOwnership = eLib.getDataFromExcelFile("Organizations", 11, 4);
		String orgEmp = eLib.getDataFromExcelFile("Organizations", 11, 5);
		
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
		
		
		WebElement industryDD = driver.findElement(By.name("industry"));
//		Select sel = new Select(industryDD);
//		sel.selectByVisibleText(orgIndustry);
		wLib.getSelectValueByValue(industryDD, orgIndustry);
		
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		driver.findElement(By.name("website")).sendKeys(orgWebsite);
//		driver.findElement(By.name("ownership")).sendKeys(orgOwnership);
//		driver.findElement(By.name("employees")).sendKeys(orgEmp);
//		driver.findElement(By.name("button")).click();
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgWebsite, orgIndustry, orgOwnership, orgEmp);
		
		String actOrgEmp = driver.findElement(By.id("dtlview_Employees")).getText();
		if(actOrgEmp.contains(orgEmp))
		{
			System.out.println("Organization Employees Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Employees Number Validation ====> FAIL");	
		}
		
		driver.close();
	}

}
