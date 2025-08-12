package com.ecom.Flipkart.Test;

import org.testng.annotations.Test;

import com.ecom.Flipkart.Framework.BaseClassFlipkart;
import com.ecom.Flipkart.ObjectRepo.MMT1HomePage;
import com.ecom.Flipkart.ObjectRepo.MMTFlightsPageTest;

public class MakeMyTripTest extends BaseClassFlipkart{

	@Test
	public void makeMyTripTest() throws Throwable {
		
		MMT1HomePage home = new MMT1HomePage(driver);
		home.searchFlightsTest();
		
		MMTFlightsPageTest flightPage = new MMTFlightsPageTest(driver);
		flightPage.getFlightsNamesAndPrice();
	}
}
