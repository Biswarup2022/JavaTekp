package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPlusIcon
{
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement leadPlusIcon;
	
	public LeadsPlusIcon(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadPlusIcon() {
		return leadPlusIcon;
	}
	
	public void clickOnLeadsPlus()
	{
		getLeadPlusIcon().click();
	}
}
