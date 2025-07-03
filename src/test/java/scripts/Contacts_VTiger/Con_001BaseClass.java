package scripts.Contacts_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.ContactPlusIcon;
import VTiger.ObjectRepo.CreateNewContact;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;


public class Con_001BaseClass extends BaseClass
{
		@Test
		public void contact001() throws Throwable
		{
			VTiger_HomePage homePage = new VTiger_HomePage(driver);
			homePage.getContactsOption().click();
			ContactPlusIcon plusIcon = new ContactPlusIcon(driver);
			plusIcon.clickOnContactPlusIcon();
			String conLastName = eLib.getDataFromExcelFile("Contacts", 2, 1)+jLib.getRandomNumber(500);
			String conTitle = eLib.getDataFromExcelFile("Contacts", 2, 2);
			String conDept = eLib.getDataFromExcelFile("Contacts", 2, 3);
			CreateNewContact newContact = new CreateNewContact(driver);
			newContact.createNewContact(conLastName, conTitle, conDept);
			
			String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(actLastName.contains(conLastName))
			{
				System.out.println("Last Name Validation ====> PASS");
			}
			else
			{
				System.out.println("Last Name Validation ====> FAIL");	
			}
		}
		
}
