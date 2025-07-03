package genericUtility.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VTigerPropertiesUtility
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TekPyramidCommonTC.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String Browser = pObj.getProperty("browser");
		String Url = pObj.getProperty("url");
		String Username = pObj.getProperty("username");
		String Password = pObj.getProperty("password");
		
		WebDriver driver = null;
		if(Browser.equals("chrome"))
			{
			driver = new ChromeDriver();
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
		
//		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
