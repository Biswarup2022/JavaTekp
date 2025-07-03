package scripts.Contacts_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.ContactPlusIcon;
import VTiger.ObjectRepo.CreateNewContact;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Con_003BaseClass extends BaseClass
{
	@Test
	public void con003() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getContactsOption().click();
		ContactPlusIcon plusIcon = new ContactPlusIcon(driver);
		plusIcon.clickOnContactPlusIcon();
		String conLastName = eLib.getDataFromExcelFile("Contacts", 8, 1);
		String conEmail = eLib.getDataFromExcelFile("Contacts", 8, 2);
		String conMob = eLib.getDataFromExcelFile("Contacts", 8, 3);
		String conMailCity = eLib.getDataFromExcelFile("Contacts", 8, 4);
		String conMailState = eLib.getDataFromExcelFile("Contacts", 8, 5);	
		String conMailCountry = eLib.getDataFromExcelFile("Contacts", 8, 6);
		CreateNewContact newContact = new CreateNewContact(driver);
		newContact.createNewContact(conLastName, conEmail, conMob, conMailCity, conMailState, conMailCountry);
		
		String actMailST = driver.findElement(By.xpath("//td[@id='mouseArea_Mailing State']")).getText();
		if(actMailST.contains(conMailState))
		{
			System.out.println("State Name Validation ====> PASS");
		}
		else
		{
			System.out.println("State Name Validation ====> FAIL");	
		}
		
		String actMailCN = driver.findElement(By.xpath("//span[@id='dtlview_Mailing Country']")).getText();
		if(actMailCN.contains(conMailCountry))
		{
			System.out.println("Country Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Country Name Validation ====> FAIL");	
		}
	}
}
