package VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

				/** POM Class Creation Stages (Total 5)
				 *Step 1 : Create a class with the name of the web page
				 *This class will be dedicated to only a specific web page
				 */
public class CreateNewContact
{
				/**
				 * Step 2 : Locate the Web elements by using @FindBy annotations
				 * This will help us to deals with StaleElementException
				 * As it will store the current element reference id every time the element loads
				 */
	@FindBy(name = "lastname")
	private WebElement lastnameTextField;
	
	@FindBy(name = "title")
	private WebElement titleTextField;
	
	@FindBy(name = "department")
	private WebElement departmentTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "mobile")
	private WebElement mobileTextField;
	
	@FindBy(name = "mailingcity")
	private WebElement mailingCityTextField;
	
	@FindBy(name = "mailingstate")
	private WebElement mailingstateTextField;
	
	@FindBy(name = "mailingcountry")
	private WebElement mailingCountryTextField;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateTextField;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateTextField;

	@FindBy(name = "button")
	private WebElement saveButton;
				
				/**
				 * Step 3 : Create a parameterized constructor by giving WebDriver driver in the parameter
				 * It'll help to call the PageFactory class to initialize the web elements
				 * Then we have to use the PageFactory Class to call the method called initElements
				 * and in the parameters we have to pass driver, this
				 * @param driver
				 */
	
	public CreateNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
				/**
				 * Step 4 : Call the getter methods from above menu option
				 * Go to Source option and select Generate Getters_And_Setters
				 * From there choose only Getters option and create them
				 * @return
				 */
	
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}


	public WebElement getTitleTextField() {
		return titleTextField;
	}


	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}


	public WebElement getEmailTextField() {
		return emailTextField;
	}


	public WebElement getMobileTextField() {
		return mobileTextField;
	}


	public WebElement getMailingCityTextField() {
		return mailingCityTextField;
	}


	public WebElement getMailingstateTextField() {
		return mailingstateTextField;
	}


	public WebElement getMailingCountryTextField() {
		return mailingCountryTextField;
	}


	public WebElement getStartDateTextField() {
		return startDateTextField;
	}


	public WebElement getEndDateTextField() {
		return endDateTextField;
	}
	
		public WebElement getSaveButton() {
		return saveButton;
	}

					/**
					 * Step 5 : Now in the last step we have to create a Business Library for each operation
					 * We'll create methods as per our excel sheet format of Individual TC data
					 * We'll prepare the methods such way that it'll fetch data from the entire row
					 * And each cell will be considered as a single argument, so an entire row will be considered in method arguments
					 * Method Overloading concept of JAVA will be used here and all the values will be pass through the method arguments
					 * @param lastName
					 * @param title
					 * @param dept
					 */

	public void createNewContact(String lastName, String title, String dept)
	{
		getLastnameTextField().sendKeys(lastName);
		getTitleTextField().sendKeys(title);
		getDepartmentTextField().sendKeys(dept);
		getSaveButton().click();
	}
	
	public void createNewContact(String lastName, String email, String mobile, String mailingCity)
	{
		getLastnameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getMobileTextField().sendKeys(mobile);
		getMailingCityTextField().sendKeys(mailingCity);
		getSaveButton().click();
	}
	
	public void createNewContact(String lastName, String email, String mobile, String mailingCity, String mailingState, String mailingCountry)
	{
		getLastnameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getMobileTextField().sendKeys(mobile);
		getMailingCityTextField().sendKeys(mailingCity);
		getMailingstateTextField().sendKeys(mailingState);
		getMailingCountryTextField().sendKeys(mailingCountry);
		getSaveButton().click();
	}
	
	public void createNewContactWD(String lastName, String email, String mobile, String mailingCity, String startDate, String endDate)
	{
		getLastnameTextField().sendKeys(lastName);
		getEmailTextField().sendKeys(email);
		getMobileTextField().sendKeys(mobile);
		getMailingCityTextField().sendKeys(mailingCity);
		getStartDateTextField().clear();
		getStartDateTextField().sendKeys(startDate);
		getEndDateTextField().clear();
		getEndDateTextField().sendKeys(endDate);
		getSaveButton().click();
	}
}

