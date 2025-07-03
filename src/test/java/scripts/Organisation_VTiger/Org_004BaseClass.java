package scripts.Organisation_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewOrg;
import VTiger.ObjectRepo.OrgPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Org_004BaseClass extends BaseClass
{
	@Test
	public void org004() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getOrganizationsOption().click();
		OrgPlusIcon plusIcon = new OrgPlusIcon(driver);
		plusIcon.clickOnOrgPlus();
		String orgName = eLib.getDataFromExcelFile("Organizations", 11, 1)+jLib.getRandomNumber(500);
		String orgWebsite = eLib.getDataFromExcelFile("Organizations", 11, 2);
		String orgIndustry = eLib.getDataFromExcelFile("Organizations", 11, 3);
		String orgOwnership = eLib.getDataFromExcelFile("Organizations", 11, 4);
		String orgEmp = eLib.getDataFromExcelFile("Organizations", 11, 5);
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgWebsite, orgIndustry, orgOwnership, orgEmp);
		
		String actOrgEmp = driver.findElement(By.id("dtlview_Employees")).getText();
		if(actOrgEmp.contains(orgEmp))
		{
			System.out.println("Organization Employees Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Employees Number Validation ====> FAIL");	
		}
	}	
}
