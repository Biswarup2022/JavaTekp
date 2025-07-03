package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPlusIcon
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgPlusIcon;
	
	public OrgPlusIcon(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgPlusIcon() {
		return orgPlusIcon;
	}
	
	public void clickOnOrgPlus()
	{
		getOrgPlusIcon().click();
	}
}
