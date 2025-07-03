package scripts.Contacts_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.ContactPlusIcon;
import VTiger.ObjectRepo.CreateNewContact;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Con_004BaseClass extends BaseClass
{
	@Test
	public void con004() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getContactsOption().click();
		ContactPlusIcon plusIcon = new ContactPlusIcon(driver);
		plusIcon.clickOnContactPlusIcon();
		String conLastName = eLib.getDataFromExcelFile("Contacts", 11, 1);
		String conEmail = eLib.getDataFromExcelFile("Contacts", 11, 2);
		String conMob = eLib.getDataFromExcelFile("Contacts", 11, 3);
		String conMailCity = eLib.getDataFromExcelFile("Contacts", 11, 4);
		String startDateStamp = jLib.getSystemDate();
		String endDateStamp = jLib.getRequiredDate(30);
		CreateNewContact newContact = new CreateNewContact(driver);
		newContact.createNewContactWD(conLastName, conEmail, conMob, conMailCity, startDateStamp, endDateStamp);
		
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.contains(startDateStamp))
		{
			System.out.println("Start Date Validation ====> PASS");
		}
		else
		{
			System.out.println("Start Date Validation ====> FAIL");	
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.contains(endDateStamp))
		{
			System.out.println("End Date Validation ====> PASS");
		}
		else
		{
			System.out.println("End Date Validation ====> FAIL");	
		}
	}
}
