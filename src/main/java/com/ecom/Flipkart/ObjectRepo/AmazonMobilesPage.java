package com.ecom.Flipkart.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.Flipkart.Framework.ExcelUtility;

public class AmazonMobilesPage {
	
	WebDriver driver;
	
	ExcelUtility eLib = new ExcelUtility();	
	
	@FindBy(xpath = "//div[@data-cy='title-recipe']//span")
	private List<WebElement> mobileNames;
	
//	div[@data-cy='price-recipe']/descendant::span[@class='a-price']/descendant::span[@class='a-price-whole'][number(translate(text(),',',''))>10000]
//	how to write xpath based on condition
	
//	@FindBy(xpath = "//div[@data-cy='price-recipe']/descendant::span[@class='a-price']/descendant::span[@class='a-price-whole']")
//	private List<WebElement> mobilePrices;

	@FindBy(xpath = "//a[text()='Next']")
	private WebElement nextPage;
	
	public AmazonMobilesPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getMobileNames() {
		return mobileNames;
	}

//	public List<WebElement> getMobilePrices() {
//		return mobilePrices;
//	}
							
	
	public void getMobilesNameAndPrice(WebDriver driver) throws Throwable {
	    int rowNum = 1; // start from row 1 (0 is for headers)
	    Actions act = new Actions(driver);

	    // Set headers in Excel
	    eLib.printDataToExcel("AmazonProducts", 0, 0, "Product Name", "Price");

	    for (int i = 1; i <= 4; i++) {
	        System.out.println("<===== Mobile Names and Prices Page " + i + " =====>");

	        for (WebElement eachNames : mobileNames) {
	            act.scrollToElement(eachNames).perform();

	            String name = eachNames.getText();
	            String price = "";

	            try {
	                price = eachNames
	                    .findElement(By.xpath("./ancestor::div[@data-cy='title-recipe']/following-sibling::div//span[@class='a-price-whole']"))
	                    .getText();
	            } catch (Exception e) {
	                price = "N/A";
	            }

	            System.out.println(name + " ==> " + price);

	            // Write to Excel for each product
	            eLib.printDataToExcel("AmazonProducts", rowNum, 0, name, price);
	            rowNum++; // Move to next row for next product
	        }

	        // Scroll and go to next page
	        act.scrollToElement(nextPage).perform();
	        nextPage.click();
	        Thread.sleep(2000); // Add wait for next page to load
	    }
	}
}
