package testScript;

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
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(l.clickOnLeads(), "Leads should be clicked");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=22)
	public static void leadsDropDown_TC21(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(l.clickOnLeads(), "Leads should be clicked");
		Assert.assertTrue(l.verifyLeadsDropDownItems(), "Leads dropdown should be verified");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=23)
	public static void leadsDefaultView_TC22(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(l.clickOnLeads(), "Leads should be clicked");
		l.selectOptionLeadsDropDown(DataUtils.readAccounts("leadsview.option"));
		UserMenu um=new UserMenu(driver, test);
		um.userMenu.click();
		um.logout.click();
		Utilities.waitForElement(driver, lp.username);
		Assert.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")),"Username should be entered");
		Assert.assertTrue(lp.enterPswd(DataUtils.readAccounts("valid.password")),"Pswd should be entered");
		Assert.assertTrue(lp.clickLogin(),"Login should be clicked");
		Assert.assertTrue(l.clickOnLeads(), "Leads should be clicked");
		Assert.assertTrue(l.validateDefaultOption((DataUtils.readAccounts("leadsview.option"))), "Leads view should be default");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=24)
	public static void validateView_TC23(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(l.clickOnLeads(), "Leads should be clicked");
		l.selectOptionLeadsDropDown(DataUtils.readAccounts("leadsview.option"));
		Assert.assertTrue(l.validateDefaultOption((DataUtils.readAccounts("leadsview.option"))), "Leads view should be default");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=25)
	public static void newLead_TC24(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Leads l=new Leads(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(l.clickOnLeads(), "Leads should be clicked");
		Assert.assertTrue(l.newwLead(), "New Lead should be created");
		logger.info(name.getName()+"---------ended-------------");
	}
}
