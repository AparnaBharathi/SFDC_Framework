package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.Contacts;
import objectRepository.LoginPage;
import utilities.Utilities;

public class ContactsScript extends BaseTest{
	@Test(priority=26)
	public static void newContact_TC25(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("New contact should be created",c.createNewContact());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=27)
	public static void newContactView_TC26(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("New contact view should be created",c.createNewContactView());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=28)
	public static void recentContact_TC27(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("Recentlycreate contact should be displayed",c.recentlyCreated());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=29)
	public static void myContactView_TC28(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("My contact view should be displayed",c.myConView());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=30)
	public static void viewContact_TC29(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("contact should be displayed",c.viewCon());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=31)
	public static void viewError_TC30(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("Error should be displayed",c.createNewViewError());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=32)
	public static void viewCancel_TC31(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("Error should be displayed",c.cancelView());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=33)
	public static void saveAndNew_TC32(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		Contacts c=new Contacts(driver,test);
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, c.contacts_tab);
		c.contacts_tab.click();
		AssertJUnit.assertTrue("Save ad New should work",c.saveandNewButton());
		logger.info(name.getName()+"---------ended-------------");
	}
}
