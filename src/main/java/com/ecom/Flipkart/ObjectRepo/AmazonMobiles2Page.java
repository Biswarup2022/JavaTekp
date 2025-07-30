package com.ecom.Flipkart.ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonMobiles2Page {

	@FindBy(xpath = "//div[@data-cy='title-recipe']/descendant::span")
	private List<WebElement> mobileNames;
}
