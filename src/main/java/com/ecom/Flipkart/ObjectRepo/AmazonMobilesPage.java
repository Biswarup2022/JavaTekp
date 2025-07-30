package com.ecom.Flipkart.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMobilesPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[@data-component-id='2']/descendant::div[@data-cy='title-recipe']/descendant::span")
	private List<WebElement> mobileNames;
	
//	div[@data-cy='price-recipe']/descendant::span[@class='a-price']/descendant::span[@class='a-price-whole'][number(translate(text(),',',''))>10000]
//	how to write xpath based on condition
	
	@FindBy(xpath = "//div[@data-cy='price-recipe']/descendant::span[@class='a-price']/descendant::span[@class='a-price-whole']")
	private List<WebElement> mobilePrices;

	@FindBy(xpath = "//a[text()='Next']")
	private WebElement nextPage;
	
	public AmazonMobilesPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getMobileNames() {
		return mobileNames;
	}

	public List<WebElement> getMobilePrices() {
		return mobilePrices;
	}
							
	
	public void getMobilesNameAndPrice() throws Throwable {
	
		driver.manage().window().minimize();
		
		for(WebElement eachNames : mobileNames) {
			
			String names = eachNames.getText();
			Thread.sleep(1000);
			System.out.println(names);
		}
		
		for(WebElement eachPrices : mobilePrices) {
			
			String prices = eachPrices.getText();
			Thread.sleep(1000);
			System.out.println(prices);
		}
		
		Actions act = new Actions(driver);
		act.scrollToElement(nextPage).perform();
		nextPage.click();
	}
}
