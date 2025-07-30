package com.ecom.Flipkart.Test;

import org.testng.annotations.Test;

import com.ecom.Flipkart.Framework.BaseClassFlipkart;
import com.ecom.Flipkart.ObjectRepo.FlipkartHomePage;
import com.ecom.Flipkart.ObjectRepo.IphoneProductPage;
import com.ecom.Flipkart.ObjectRepo.SelectedTshirtPage;
import com.ecom.Flipkart.ObjectRepo.TshirtsPage;

public class FlipkartTest extends BaseClassFlipkart {

	@Test
	public void flipkartTest() throws Throwable {
		
		String iphone = eLib.getDataFromExcel("MobileSheet", 1, 0);
		
		FlipkartHomePage homePage = new FlipkartHomePage(driver);
		homePage.searchIphone(iphone);
		
		IphoneProductPage productPage = new IphoneProductPage(driver);
		productPage.getClickOnMenAndTshirts(driver);
		
		TshirtsPage tShirt = new TshirtsPage(driver);
		tShirt.selectTShirt(driver);
		
		sLib.getSwitchToWindowByTitle(driver);
		Thread.sleep(2000);
		
		SelectedTshirtPage selectedTshirtPage = new SelectedTshirtPage(driver);
		selectedTshirtPage.addTshirtToCart(driver);
		
	}
	
}
