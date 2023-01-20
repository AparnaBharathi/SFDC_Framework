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

import objectRepository.LoginPage;
import objectRepository.UserMenu;
import utilities.DataUtils;
import utilities.Utilities;

public class UserMenuScript extends BaseTest{

	@Test(priority=6)
	public static void verifyItems_TC05(Method name) throws IOException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.verifyUserMenuItems());
		logger.info("******Ending test *********" +name.getName());
}
	
	@Test(priority=7)
	public static void myProfile_TC06(Method name) throws IOException, InterruptedException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.verifyUserMenuItems());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Profile"));
		Thread.sleep(3000);
		Utilities.waitForElement(driver, um.editProfile);
		AssertJUnit.assertTrue(um.editProf());
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Profile"));
		Utilities.waitForElement(driver, um.postLink);
		AssertJUnit.assertTrue(um.post());
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Profile"));
		AssertJUnit.assertTrue(um.uploadFile());
		logger.info("******Ending test *********" +name.getName());
}
	
	@Test(priority=8)
	public static void mySettings_TC07(Method name) throws IOException, InterruptedException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.verifyUserMenuItems());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"));
		AssertJUnit.assertTrue(um.downloadLoginHistory());
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"));
		AssertJUnit.assertTrue(um.removeTab("Chatter"));
		AssertJUnit.assertTrue(um.addTab("Chatter"));
		AssertJUnit.assertTrue(um.verifyTab("Chatter_Tab"));
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"));
		AssertJUnit.assertTrue(um.emailEdit());
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"));
		AssertJUnit.assertTrue(um.calendar_reminder());
		logger.info("******Ending test *********" +name.getName());
}
	
	@Test(priority=9)
	public static void developerConsole_TC08(Method name) throws IOException  {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.verifyUserMenuItems());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("Developer Console"));
		AssertJUnit.assertTrue(um.developerConsole());
		logger.info("******Ending test *********" +name.getName());
	}
	
	@Test(priority=10)
	public static void logout_TC09(Method name) throws IOException  {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.verifyUserMenuItems());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("Logout"));
		Utilities.waitForElement(driver, lp.username);
		AssertJUnit.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")));
		logger.info("******Ending test *********" +name.getName());
	}
}
	