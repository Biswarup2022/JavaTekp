package scripts.Leads_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewLeads;
import VTiger.ObjectRepo.LeadsPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Leads_002BaseClass extends BaseClass
{
	@Test
	public void leads002() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getLeadsOption().click();
		LeadsPlusIcon plusIcon = new LeadsPlusIcon(driver);
		plusIcon.clickOnLeadsPlus();
		String leadsFirstName = eLib.getDataFromExcelFile("Leads", 5, 1);
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 5, 2)+jLib.getRandomNumber(500);
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 5, 3)+jLib.getRandomNumber(500);
		String leadsTitleName = eLib.getDataFromExcelFile("Leads", 5, 4)+jLib.getRandomNumber(500);
		String leadsMob = eLib.getDataFromExcelFile("Leads", 5, 5);
		String leadsEmail = eLib.getDataFromExcelFile("Leads", 5, 6);
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsFirstName, leadsLastName,leadsCompanyName , leadsTitleName, leadsMob, leadsEmail);
		
		String actMob = driver.findElement(By.id("dtlview_Mobile")).getText();
		if(actMob.equals(leadsMob))
		{
			System.out.println("Mobile Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Mobile Number Validation ====> FAIL");	
		}
		
		String actEmail = driver.findElement(By.id("dtlview_Email")).getText();
		if(actEmail.contains(leadsEmail))
		{
			System.out.println("Email Validation ====> PASS");
		}
		else
		{
			System.out.println("Email Validation ====> FAIL");	
		}
	}
}
