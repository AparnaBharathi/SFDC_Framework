package testScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


import objectRepository.CreateOptunty;
import objectRepository.LoginPage;
import utilities.Utilities;

public class createOptuntyScript extends BaseTest{

	@Test(priority=16)
	public static void verifyOptunty_TC15(Method name) throws IOException  {
		logger.info(name.getName()+"--------- started-----------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		Utilities.waitForElement(driver, co.opDropDown);
		co.opDropDown.click();
		Assert.assertTrue(co.verifyOpDropDownItems(),"Items should be verified");
		Assert.assertTrue(co.selectOptionOpDropDown(3),"Option should be selected");
		logger.info(name.getName()+" --------ended---------");
	}
	
	@Test(priority=17)
	public static void newOptunty_TC16(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		Assert.assertTrue(co.createNewOp(),"New oportunity should be created");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=18)
	public static void optuntyPipeline_TC17(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		Assert.assertTrue(co.opPipeline(),"Opportunity pipeline should be created");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=19)
	public static void stuckOptuntyReport_TC18(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		Assert.assertTrue(co.opStuckReport(),"Opportunity Stuck report should be created");
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=20)
	public static void opQuatReport_TC19(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		Assert.assertTrue(co.quatSummaryReport(),"Quaterly report should be created");
		logger.info(name.getName()+"---------ended-------------");
	}
}
