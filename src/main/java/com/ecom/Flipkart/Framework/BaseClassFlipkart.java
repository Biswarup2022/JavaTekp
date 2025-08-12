package com.ecom.Flipkart.Framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassFlipkart {

	public WebDriver driver = null;

	public PropertiesUtility pLib = new PropertiesUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public SeleniumUtility sLib = new SeleniumUtility();

	@BeforeSuite
	public void configBS() {
		
		System.out.println("Before Suite Annotation => Connect to DataBase, Report config");	
	}

	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		
		String Browser = pLib.getDataFromPropertiesFile("browser");
		String URLFlipkart = pLib.getDataFromPropertiesFile("url");
		String URLAmazon = pLib.getDataFromPropertiesFile("urlAmazon");
		String URLmakeMyTrip = pLib.getDataFromPropertiesFile("urlMMT");
		
		if(Browser.equals("chrome"))
		{
		driver = new ChromeDriver(); // options
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
		
		sLib.getImplycitlyWaitAndMaximize(driver);
//		sLib.getURLToFlipkart(driver, URLFlipkart);
//		sLib.getURLToAmazon(driver, URLAmazon);
		sLib.getURLToAmazon(driver, URLmakeMyTrip);
		
		System.out.println("<<<< Browser Launched Successfully >>>>");
	}
	
	@BeforeMethod
	public void configBM() {
		
		System.out.println("Before Method Annotation => Perfomed Login to Application");
	}

	@AfterClass
	public void configAC() {
		
		System.out.println("After Class Annotation => Successfully Closed the Browser");
//		driver.quit();
	}
	
	@AfterMethod
	public void configAM() {
		
		System.out.println("Before Method Annotation => Perfomed Logout to Application");
		
	}

	@AfterSuite
	public void configAS() {
		
		System.out.println("After Suite Annotation => Closed DataBase Connection, Report Backup");
		
	}
}
