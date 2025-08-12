package com.ecom.Flipkart.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.Flipkart.Framework.SeleniumUtility;

public class MMTFlightsPageTest {

	@FindBy(xpath = "//p[@class='fliCode']")
	private List<WebElement> flightNames;
	
	public MMTFlightsPageTest(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getFlightNames() {
		return flightNames;
	}
	
	public void getFlightsNamesAndPrice() {
		
		SeleniumUtility sLib = new SeleniumUtility();
		
		for(WebElement names : flightNames) {
			
			String name = names.getText();
			String price = "";
			
			try {
				price = names
						.findElement(By.xpath("./ancestor::div[@class='makeFlex spaceBetween ']/descendant::span[@class=' fontSize18 blackFont']"))
						.getText();
			} catch (Exception e) {
				price = "N/A";
			}
			
			System.out.println(name+" ==> "+price);
		}
	}
}
