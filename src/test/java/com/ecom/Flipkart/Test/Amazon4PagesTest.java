package com.ecom.Flipkart.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ecom.Flipkart.Framework.BaseClassFlipkart;
import com.ecom.Flipkart.ObjectRepo.AmazonHomePage;
import com.ecom.Flipkart.ObjectRepo.AmazonMobilesPage;

public class Amazon4PagesTest extends BaseClassFlipkart {

	@Test
	public void amazon4ProductPageTest() throws Throwable {
		
		String mobile = eLib.getDataFromExcel("MobileSheet", 1, 7);
		AmazonHomePage homePage = new AmazonHomePage(driver);
		homePage.searchMobile(mobile);
		
		String brand = "Redmi";
		driver.findElement(By.xpath("(//ul[@id='filter-p_123']/descendant::span[text()='"+brand+"'])[last()]")).click();
		
		AmazonMobilesPage mobilesPage = new AmazonMobilesPage(driver);
		mobilesPage.getMobilesNameAndPrice(driver);
		
	}
}
