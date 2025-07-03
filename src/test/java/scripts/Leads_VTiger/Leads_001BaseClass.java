package scripts.Leads_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewLeads;
import VTiger.ObjectRepo.LeadsPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Leads_001BaseClass extends BaseClass
{
	@Test
	public void leads001() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getLeadsOption().click();
		LeadsPlusIcon plusIcon = new LeadsPlusIcon(driver);
		plusIcon.clickOnLeadsPlus();
		String leadsFirstName = eLib.getDataFromExcelFile("Leads", 2, 1);
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 2, 2)+jLib.getRandomNumber(500);
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 2, 3)+jLib.getRandomNumber(500);
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsFirstName, leadsLastName, leadsCompanyName);
		
		String actFirstName = driver.findElement(By.id("dtlview_First Name")).getText();
		if(actFirstName.contains(leadsFirstName))
		{
			System.out.println("First Name Validation ====> PASS");
		}
		else
		{
			System.out.println("First Name Validation ====> FAIL");	
		}
		
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actLastName.contains(leadsLastName))
		{
			System.out.println("Last Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Last Name Validation ====> FAIL");	
		}
		
		String actCompanyName = driver.findElement(By.id("dtlview_Company")).getText();
		if(actCompanyName.equals(leadsCompanyName))
		{
			System.out.println("Company Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Company Name Validation ====> FAIL");	
		}

	}
}
