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
		AssertJUnit.assertTrue("Login should happen", lp.loginToSFDC());
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		Utilities.waitForElement(driver, co.opDropDown);
		co.opDropDown.click();
		AssertJUnit.assertTrue(co.verifyOpDropDownItems());
		AssertJUnit.assertTrue(co.selectOptionOpDropDown(3));
		logger.info(name.getName()+" --------ended---------");
	}
	
	@Test(priority=17)
	public static void newOptunty_TC16(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		AssertJUnit.assertTrue(co.createNewOp());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=18)
	public static void optuntyPipeline_TC17(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		AssertJUnit.assertTrue(co.opPipeline());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=19)
	public static void stuckOptuntyReport_TC18(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		AssertJUnit.assertTrue(co.opStuckReport());
		logger.info(name.getName()+"---------ended-------------");
	}
	
	@Test(priority=20)
	public static void opQuatReport_TC19(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, co.opTab);
		co.opTab.click();
		AssertJUnit.assertTrue(co.quatSummaryReport());
		logger.info(name.getName()+"---------ended-------------");
	}
}
