package genericUtility.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenerateRandomNumber
{
	public static void main(String[] args) throws Throwable
	{
		/**
		 * Random Number is used to make a unique value
		 * if we have to pass 1000 unique, it is impossible to give all unique values
		 * so that we have to concatenate the variable with random variable reference
		 * it'll generate an unique value every time it run
		 */
		Random ran = new Random();
		int var = ran.nextInt(100);
//		System.out.println(var);
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TekPyramidCommonTC.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		String orgName = "abc";
		
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
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+var);
		Thread.sleep(2000);
		driver.close();	
		
		
		
	}
}
