package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VTiger_HomePage
{
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeOption;

	@FindBy(linkText = "Leads")
	private WebElement leadsOption;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsOption;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsOption;
	
	@FindBy(linkText = "Products")
	private WebElement productsOption;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsOption;
	
	@FindBy(linkText = "Email")
	private WebElement emailOption;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesOption;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutDD;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutOption;
	
	public VTiger_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeOption() {
		return homeOption;
	}

	public WebElement getLeadsOption() {
		return leadsOption;
	}

	public WebElement getOrganizationsOption() {
		return organizationsOption;
	}

	public WebElement getContactsOption() {
		return contactsOption;
	}

	public WebElement getProductsOption() {
		return productsOption;
	}

	public WebElement getDocumentsOption() {
		return documentsOption;
	}

	public WebElement getEmailOption() {
		return emailOption;
	}

	public WebElement getOpportunitiesOption() {
		return opportunitiesOption;
	}

	public WebElement getLogoutDD() {
		return logoutDD;
	}

	public WebElement getSignoutOption() {
		return signoutOption;
	}
	
	public void SignOutOperation(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(logoutDD).perform();
		act.click(signoutOption).perform();
	}
}
