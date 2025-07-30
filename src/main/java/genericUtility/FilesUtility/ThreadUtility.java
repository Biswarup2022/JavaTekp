package genericUtility.FilesUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ThreadUtility {
	
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	/**
	 * @return the test
	 */
	public static ExtentTest getTest() {
		return test.get();
	}
	/**
	 * @param test the test to set
	 */
	public static void setTest (ExtentTest actTest) {
		test.set(actTest);
	}
	/**
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}
	/**
	 * @param driver the driver to set
	 */
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
	
	
}
