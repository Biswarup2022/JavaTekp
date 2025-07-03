package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPlusIcon
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactPlusIcon;
	
	public ContactPlusIcon(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactPlusIcon() {
		return contactPlusIcon;
	}
	
	public void clickOnContactPlusIcon()
	{
		getContactPlusIcon().click();
	}
}
