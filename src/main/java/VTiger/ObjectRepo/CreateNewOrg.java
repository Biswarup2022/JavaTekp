package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrg
{
	@FindBy(name = "accountname")
	private WebElement orgNameTextField;
	
	@FindBy(name = "website")
	private WebElement websiteTextField;

	@FindBy(name = "ownership")
	private WebElement ownershipTextField;
	
	@FindBy(name = "email1")
	private WebElement emailTextField;
	
	@FindBy(name = "phone")
	private WebElement phoneTextField;
	
	@FindBy(name = "bill_city")
	private WebElement billingCityTextField;

	@FindBy(name = "ship_city")
	private WebElement shippingCityTextField;

	@FindBy(name = "ship_state")
	private WebElement shippingSateTextField;
	
	@FindBy(name = "ship_country")
	private WebElement shippingCountryTextField;
	
	@FindBy(name = "industry")
	private WebElement industryTextField;
	
	@FindBy(name = "employees")
	private WebElement empNoTextField;
	
	@FindBy(name = "button")
	private WebElement saveButton;
	
	public CreateNewOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getOwnershipTextField() {
		return ownershipTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getBillingCityTextField() {
		return billingCityTextField;
	}

	public WebElement getShippingCityTextField() {
		return shippingCityTextField;
	}

	public WebElement getShippingSateTextField() {
		return shippingSateTextField;
	}

	public WebElement getShippingCountryTextField() {
		return shippingCountryTextField;
	}

	public WebElement getIndustryTextField() {
		return industryTextField;
	}

	public WebElement getEmpNoTextField() {
		return empNoTextField;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createNewOrg(String orgName, String website, String ownership)
	{
		getOrgNameTextField().sendKeys(orgName);
		getWebsiteTextField().sendKeys(website);
		getOwnershipTextField().sendKeys(ownership);
		getSaveButton().click();
	}
	
	public void createNewOrg(String orgName, String email, String phone, String billingCity)
	{
		getOrgNameTextField().sendKeys(orgName);
		getEmailTextField().sendKeys(email);
		getPhoneTextField().sendKeys(phone);
		getBillingCityTextField().sendKeys(billingCity);
		getSaveButton().click();
	}
	
	public void createNewOrg(String orgName, String email, String phone, String shippingCity, String shippingState, String shippingCountry)
	{
		getOrgNameTextField().sendKeys(orgName);
		getEmailTextField().sendKeys(email);
		getPhoneTextField().sendKeys(phone);
		getShippingCityTextField().sendKeys(shippingCity);
		getShippingSateTextField().sendKeys(shippingState);
		getShippingCountryTextField().sendKeys(shippingCountry);
		getSaveButton().click();		
	}
	
	public void createNewOrg(String orgName, String website, String industry, String ownership, String EmpNo)
	{
		getOrgNameTextField().sendKeys(orgName);
		getWebsiteTextField().sendKeys(website);
		getOwnershipTextField().sendKeys(ownership);
		getEmpNoTextField().sendKeys(EmpNo);
		getSaveButton().click();		
	}
}
