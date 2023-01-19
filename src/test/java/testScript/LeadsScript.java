package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


import objectRepository.Leads;
import objectRepository.LoginPage;
import objectRepository.UserMenu;
import utilities.DataUtils;
import utilities.Utilities;

public class LeadsScript extends BaseTest{

	@Test(priority=21)
	public static void leadsClick_TC20(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		AssertJUnit.assertTrue("Leads should be clicked", l.clickOnLeads());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=22)
	public static void leadsDropDown_TC21(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		AssertJUnit.assertTrue("Leads should be clicked", l.clickOnLeads());
		AssertJUnit.assertTrue("Leads dropdown should be verified", l.verifyLeadsDropDownItems());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=23)
	public static void leadsDefaultView_TC22(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		AssertJUnit.assertTrue("Leads should be clicked", l.clickOnLeads());
		l.selectOptionLeadsDropDown(DataUtils.readAccounts("leadsview.option"));
		UserMenu um=new UserMenu(driver, test);
		um.userMenu.click();
		um.logout.click();
		Utilities.waitForElement(driver, lp.username);
		AssertJUnit.assertTrue("Username should be entered",lp.enterUsername(DataUtils.readAccounts("valid.username")));
		AssertJUnit.assertTrue("Pswd should be entered",lp.enterPswd(DataUtils.readAccounts("valid.password")));
		AssertJUnit.assertTrue("Login should be clicked",lp.clickLogin());
		AssertJUnit.assertTrue("Leads should be clicked", l.clickOnLeads());
		AssertJUnit.assertTrue("Leads view should be default", l.validateDefaultOption((DataUtils.readAccounts("leadsview.option"))));
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=24)
	public static void validateView_TC23(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		AssertJUnit.assertTrue("Leads should be clicked", l.clickOnLeads());
		l.selectOptionLeadsDropDown(DataUtils.readAccounts("leadsview.option"));
		AssertJUnit.assertTrue("Leads view should be default", l.validateDefaultOption((DataUtils.readAccounts("leadsview.option"))));
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=25)
	public static void newLead_TC24(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		AssertJUnit.assertTrue("Leads should be clicked", l.clickOnLeads());
		AssertJUnit.assertTrue("New Lead should be created", l.newwLead());
		logger.info(name.getName()+"---------ended-------------");
	}
}
