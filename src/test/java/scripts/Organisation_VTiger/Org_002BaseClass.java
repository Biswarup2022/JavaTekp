package scripts.Organisation_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewOrg;
import VTiger.ObjectRepo.OrgPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Org_002BaseClass extends BaseClass
{
	@Test
	public void org002() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getOrganizationsOption().click();
		OrgPlusIcon plusIcon = new OrgPlusIcon(driver);
		plusIcon.clickOnOrgPlus();
		String orgName = eLib.getDataFromExcelFile("Organizations", 5, 1)+jLib.getRandomNumber(500);
		String orgEmail = eLib.getDataFromExcelFile("Organizations", 5, 2);
		String orgPhone = eLib.getDataFromExcelFile("Organizations", 5, 3);
		String orgBillCity = eLib.getDataFromExcelFile("Organizations", 5, 4);
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgEmail, orgPhone, orgBillCity);
		
		String actOrgEmail = driver.findElement(By.id("dtlview_Email")).getText();
		if(actOrgEmail.contains(orgEmail))
		{
			System.out.println("Organization Email Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Email Validation ====> FAIL");	
		}
		
		String actOrgPhone = driver.findElement(By.id("dtlview_Phone")).getText();
		if(actOrgPhone.contains(orgPhone))
		{
			System.out.println("Organization Phone Number Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Phone Number Validation ====> FAIL");	
		}
		
		String actOrgBillCity = driver.findElement(By.id("dtlview_Billing City")).getText();
		if(actOrgBillCity.contains(orgBillCity))
		{
			System.out.println("Organization Billing City Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Billing City Validation ====> FAIL");	
		}
	}	
}
