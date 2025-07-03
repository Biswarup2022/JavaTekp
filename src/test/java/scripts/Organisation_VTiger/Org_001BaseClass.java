package scripts.Organisation_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewOrg;
import VTiger.ObjectRepo.OrgPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Org_001BaseClass extends BaseClass
{
	@Test
	public void org001() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getOrganizationsOption().click();
		OrgPlusIcon plusIcon = new OrgPlusIcon(driver);
		plusIcon.clickOnOrgPlus();
		String orgName = eLib.getDataFromExcelFile("Organizations", 2, 1)+jLib.getRandomNumber(500);
		String orgWebsite = eLib.getDataFromExcelFile("Organizations", 2, 2);
		String orgOwnership = eLib.getDataFromExcelFile("Organizations", 2, 3);
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgWebsite, orgOwnership);
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println("Organization Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Name Validation ====> FAIL");	
		}
		
		String actOrgWebsite = driver.findElement(By.id("dtlview_Website")).getText();
		if(actOrgWebsite.contains(orgWebsite))
		{
			System.out.println("Website Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Website Name Validation ====> FAIL");	
		}
		
		String actOrgOwnership = driver.findElement(By.id("dtlview_Ownership")).getText();
		if(actOrgOwnership.contains(orgOwnership))
		{
			System.out.println("Organization Ownership Name Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Ownership Name Validation ====> FAIL");	
		}
	}
}
