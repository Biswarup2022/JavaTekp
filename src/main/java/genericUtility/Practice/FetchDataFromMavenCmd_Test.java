package genericUtility.Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FetchDataFromMavenCmd_Test
{

	@Test
	public void login() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		String Browser = System.getProperty("browser");
		System.out.println(Browser);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(".\\src\\test\\resources\\AppCommonData.json"));
		JSONObject map = (JSONObject)obj;
		
//		String Browser = map.get("browser").toString();
		String Url = map.get("url").toString();
		String Username = map.get("username").toString();
		String Password = map.get("password").toString();
		
		WebDriver driver;
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
		Thread.sleep(2000);
		driver.close();	
	}
}
