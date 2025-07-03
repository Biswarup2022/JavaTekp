package scripts.Contacts_VTiger;

import org.openqa.selenium.By;

import VTiger.ObjectRepo.ContactPlusIcon;
import VTiger.ObjectRepo.CreateNewContact;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Con_002BaseClass extends BaseClass
{
	public void con002() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getContactsOption().click();
		ContactPlusIcon plusIcon = new ContactPlusIcon(driver);
		plusIcon.clickOnContactPlusIcon();
		String conLastName = eLib.getDataFromExcelFile("Contacts", 5, 1)+jLib.getRandomNumber(500);		
		String conEmail = eLib.getDataFromExcelFile("Contacts", 5, 2);
		String conMob = eLib.getDataFromExcelFile("Contacts", 5, 3);
		String conMailCity = eLib.getDataFromExcelFile("Contacts", 5, 4);
		CreateNewContact newContact = new CreateNewContact(driver);
		newContact.createNewContact(conLastName, conEmail, conMob, conMailCity);
		
		String actEmail = driver.findElement(By.id("mouseArea_Email")).getText();
		if(actEmail.contains(conEmail))
		{
			System.out.println("Email Validation ====> PASS");
		}
		else
		{
			System.out.println("Email Validation ====> FAIL");	
		}
		
		String actMob = driver.findElement(By.id("dtlview_Mobile")).getText();
		if(actMob.equals(conMob))
		{
			System.out.println("Mobile Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Mobile Number Validation ====> FAIL");			
		}
	}
}
