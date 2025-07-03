package genericUtility.FilesUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility
{
				/**
				 * Wait for loading the page and maximizing the window
				 */

	public void implicitlyWaitAndMX(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	public void explicitlyWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void urlToVTiger(WebDriver driver, String url)
	{
		driver.get(url);	
	}
				/**
				 * Select Class Methods
				 */
	
	public void getSelectValueByIndex(WebElement dropdownElement, int index)
	{
		Select sel = new Select(dropdownElement);
		sel.selectByIndex(index);
	}
	
	public void getSelectValueByVisibleText(WebElement dropdownElement, String visibleText)
	{
		Select sel = new Select(dropdownElement);
		sel.selectByVisibleText(visibleText);
	}
	
	public void getSelectValueByValue(WebElement dropdownElement, String value)
	{
		Select sel = new Select(dropdownElement);
		sel.selectByValue(value);
	}
	
				/**
				 * Switching windows methods
				 */
	
	public void getSwitchToNewWindowByURL(WebDriver driver, String partialUrl)
	{
		String parentID = driver.getWindowHandle();
		Set<String> allIDs = driver.getWindowHandles();
		for(String newID : allIDs)
		{
			if(!newID.equals(allIDs))
			{
				driver.switchTo().window(newID);
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.equals(partialUrl))
				{
					break;
				}
				
			}
		}
	}
	
	public void getSwitchToNewWindowByTitle(WebDriver driver, String partialTitle)
	{
		String parentId = driver.getWindowHandle();
		Set<String> allIDs = driver.getWindowHandles();
		for(String newID : allIDs)
		{
			if(!newID.equals(parentId))
			{
				driver.switchTo().window(newID);
				String actualTitle = driver.getTitle();
				if(actualTitle.equals(partialTitle))
				{
					break;
				}
			}
		}
	}
	
				/**
				 * Handling Alert PopUps methods
				 */
	
	public void getAcceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void getDissmisAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertMessage(WebDriver driver)
	{
		String alertMeassage = driver.switchTo().alert().getText();
		return alertMeassage;
	}
	
	public void getSendDataIntoAlert(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
				/**
				 * Handling Mouse Actions Class methods
				 */
	
	public void getMouseHoverElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void getMouseHoverAndClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void getScrollToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void getDoubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void getRightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void getClickAndHoldOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void getReleaseOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	
	public void getDragAndDropOnElement(WebDriver driver, WebElement element1, WebElement element2)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(element1, element2).perform();
	}
	
	public void getDragAndDropByOnElement(WebDriver driver, WebElement element1, int xOffset, int yOffset)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(element1, xOffset, yOffset).perform();
	}
	
				/**
				 * Handling Screenshots methods
				 */
	
	public void getScreenshotOnElement(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
	}
	
				/**
				 * Handling JavaScript methods
				 */
	
	public void getScrollToElementByJS(WebDriver driver, String syntax)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript(syntax);
//		(Syntax = window.scrollBy(0,1500);) ====> From current point
//		(Syntax = window.scrollTo(0,1500);) ====> From top point
	}
	
				/**
				 * For Switching Frames methods
				 */
	
	public void getSwitchToFrameByIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void getSwitchToFrameByAttributeName(WebDriver driver, String attName)
	{
		driver.switchTo().frame(attName);
	}
	
	public void getSwitchToFrameByWebElementName(WebDriver driver, WebElement elementName)
	{
		driver.switchTo().frame(elementName);
	}
	
	public void getSwitchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void getSwitchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
				/**
				 * For Uploading File without Input Tags methods
				 */
	
	public void getFileUploadWithOutInputTag(WebDriver driver, String filePath, WebElement element) throws Throwable
	{
		StringSelection path = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		element.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
