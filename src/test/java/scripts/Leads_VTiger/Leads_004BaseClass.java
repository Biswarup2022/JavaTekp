package scripts.Leads_VTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewLeads;
import VTiger.ObjectRepo.LeadsPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Leads_004BaseClass extends BaseClass
{
	@Test
	public void leads004() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getLeadsOption().click();
		LeadsPlusIcon plusIcon = new LeadsPlusIcon(driver);
		plusIcon.clickOnLeadsPlus();
		String leadsFirstName = eLib.getDataFromExcelFile("Leads", 11, 1);
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 11, 2)+jLib.getRandomNumber(500);
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 11, 3)+jLib.getRandomNumber(500);
		String leadSource = eLib.getDataFromExcelFile("Leads", 11, 4);
		String leadsPostal = eLib.getDataFromExcelFile("Leads", 11, 5);
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsFirstName, leadsLastName, leadsCompanyName, leadSource, leadsPostal);
		WebElement leadSourceDD = driver.findElement(By.name("leadsource"));
		wLib.getSelectValueByVisibleText(leadSourceDD, leadSource);
		String actPostal = driver.findElement(By.id("dtlview_Postal Code")).getText();
		if(actPostal.contains(leadsPostal))
		{
			System.out.println("Postal Code Validation ====> PASS");
		}
		else
		{
			System.out.println("Postal Code Validation ====> FAIL");	
		}
	}
}
