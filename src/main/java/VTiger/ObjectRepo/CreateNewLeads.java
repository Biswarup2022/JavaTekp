package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeads
{
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "company")
	private WebElement companyTextField;
	
	@FindBy(name = "designation")
	private WebElement titleTextField;
	
	@FindBy(name = "mobile")
	private WebElement mobileTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
		
	@FindBy(name = "leadsource")
	private WebElement leadSourceDD;
	
	@FindBy(name = "noofemployees")
	private WebElement empNoTextField;
	
	@FindBy(name = "city")
	private WebElement cityTextField;
	
	@FindBy(name = "country")
	private WebElement countryTextField;

	@FindBy(name = "state")
	private WebElement stateTextField;
	
	@FindBy(name = "code")
	private WebElement postalCodeTextField;

	@FindBy(name = "button")
	private WebElement saveButton;
	
	public CreateNewLeads(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyTextField() {
		return companyTextField;
	}

	public WebElement getTitleTextField() {
		return titleTextField;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getLeadSourceDD() {
		return leadSourceDD;
	}

	public WebElement getEmpNoTextField() {
		return empNoTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}

	public WebElement getStateTextField() {
		return stateTextField;
	}

	public WebElement getPostalCodeTextField() {
		return postalCodeTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createNewLeads(String firstName, String lastName, String company)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getSaveButton().click();
	}
	
	public void createNewLeads(String firstName, String lastName, String company, String title, String mobile, String email)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getTitleTextField().sendKeys(title);
		getMobileTextField().sendKeys(mobile);
		getEmailTextField().sendKeys(email);
		getSaveButton().click();
	}
	
	public void createNewLeads(String lastName, String company, String leadSource, String numberOfEMP, String city, String country, String state)
	{
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getLeadSourceDD().sendKeys(leadSource);
		getEmpNoTextField().sendKeys(numberOfEMP);
		getCityTextField().sendKeys(city);
		getCountryTextField().sendKeys(country);
		getStateTextField().sendKeys(state);
		getSaveButton().click();
	}
	
	public void createNewLeads(String firstName, String lastName, String company, String leadSource, String postalCode)
	{
		getFirstNameTextField().sendKeys(firstName);
		getLastNameTextField().sendKeys(lastName);
		getCompanyTextField().sendKeys(company);
		getLeadSourceDD().sendKeys(leadSource);
		getPostalCodeTextField().sendKeys(postalCode);
		getSaveButton().click();
	}
}
