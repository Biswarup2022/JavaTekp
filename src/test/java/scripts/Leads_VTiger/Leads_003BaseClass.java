package scripts.Leads_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewLeads;
import VTiger.ObjectRepo.LeadsPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Leads_003BaseClass extends BaseClass
{
	@Test
	public void leads003() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getLeadsOption().click();
		LeadsPlusIcon plusIcon = new LeadsPlusIcon(driver);
		plusIcon.clickOnLeadsPlus();
		String leadsLastName = eLib.getDataFromExcelFile("Leads", 8, 1)+jLib.getRandomNumber(500);
		String leadsCompanyName = eLib.getDataFromExcelFile("Leads", 8, 2)+jLib.getRandomNumber(500);
		String leadsSource = eLib.getDataFromExcelFile("Leads", 8, 3);
		String leadsEmpNo = eLib.getDataFromExcelFile("Leads", 8, 4);
		String leadsCity = eLib.getDataFromExcelFile("Leads", 8, 5);
		String leadsCountry = eLib.getDataFromExcelFile("Leads", 8, 6);
		String leadsState = eLib.getDataFromExcelFile("Leads", 8, 7);
		CreateNewLeads newLeads = new CreateNewLeads(driver);
		newLeads.createNewLeads(leadsLastName, leadsCompanyName, leadsSource, leadsEmpNo, leadsCity, leadsCountry, leadsState);
		
		String actLeadSource = driver.findElement(By.id("dtlview_Lead Source")).getText();
		if(actLeadSource.contains("Partner"))
		{
			System.out.println("Lead Source Validation ====> PASS");
			}
			else
			{
				System.out.println("Lead Source Validation ====> FAIL");	
			}
		
		String actEmpNo = driver.findElement(By.id("dtlview_No Of Employees")).getText();
		if(actEmpNo.contains(leadsEmpNo))
		{
			System.out.println("Employee Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Employee Number Validation ====> FAIL");	
		}
		
		String actCountry = driver.findElement(By.id("dtlview_Country")).getText();
		if(actCountry.contains(leadsCountry))
		{
			System.out.println("Country Validation ====> PASS");
		}
		else
		{
			System.out.println("Country Validation ====> FAIL");	
		}
	}
}
