package scripts.Organisation_VTiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import VTiger.ObjectRepo.CreateNewOrg;
import VTiger.ObjectRepo.OrgPlusIcon;
import VTiger.ObjectRepo.VTiger_HomePage;
import genericUtility.FilesUtility.BaseClass;

public class Org_003BaseClass extends BaseClass
{
	@Test
	public void org003() throws Throwable
	{
		VTiger_HomePage homePage = new VTiger_HomePage(driver);
		homePage.getOrganizationsOption().click();
		OrgPlusIcon plusIcon = new OrgPlusIcon(driver);
		plusIcon.clickOnOrgPlus();
		String orgName = eLib.getDataFromExcelFile("Organizations", 8, 1)+jLib.getRandomNumber(500);
		String orgEmail = eLib.getDataFromExcelFile("Organizations", 8, 2);
		String orgPhone = eLib.getDataFromExcelFile("Organizations", 8, 3);
		String orgShippingCity = eLib.getDataFromExcelFile("Organizations", 8, 4);
		String orgShippingState = eLib.getDataFromExcelFile("Organizations", 8, 5);
		String orgShippingCountry = eLib.getDataFromExcelFile("Organizations", 8, 6);
		CreateNewOrg newOrg = new CreateNewOrg(driver);
		newOrg.createNewOrg(orgName, orgEmail, orgPhone, orgShippingCity, orgShippingState, orgShippingCountry);
		
		String actOrgShippingCity = driver.findElement(By.id("dtlview_Shipping City")).getText();
		if(actOrgShippingCity.contains(orgShippingCity))
		{
			System.out.println("Organization Shipping City Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Shipping City Validation ====> FAIL");	
		}
		
		String actOrgShippingState = driver.findElement(By.id("dtlview_Shipping State")).getText();
		if(actOrgShippingState.contains(orgShippingState))
		{
			System.out.println("Organization Shipping State Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Shipping State Validation ====> FAIL");	
		}
		
		String actOrgShippingCountry = driver.findElement(By.id("dtlview_Shipping Country")).getText();
		if(actOrgShippingCountry.contains(orgShippingCountry))
		{
			System.out.println("Organization Shipping Country Validation ====> PASS");
		}
		else
		{
			System.out.println("Organization Shipping Country Validation ====> FAIL");	
		}
	}	
}
