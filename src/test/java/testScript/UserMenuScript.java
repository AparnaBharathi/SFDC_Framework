package testScript;

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
		AssertJUnit.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.verifyUserMenuItems(),"User Menu items should be found");
		logger.info("******Ending test *********" +name.getName());
}
	
	@Test(priority=7)
	public static void myProfile_TC06(Method name) throws IOException, InterruptedException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.verifyUserMenuItems(),"User Menu items should be found");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Profile"),"should be found");
		Thread.sleep(3000);
		Utilities.waitForElement(driver, um.editProfile);
		AssertJUnit.assertTrue(um.editProf(),"Profile name should be edited");
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Profile"),"should be found");
		Utilities.waitForElement(driver, um.postLink);
		AssertJUnit.assertTrue(um.post(),"Posted");
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Profile"),"should be found");
		AssertJUnit.assertTrue(um.uploadFile(),"File should be uplaoded");
		logger.info("******Ending test *********" +name.getName());
}
	
	@Test(priority=8)
	public static void mySettings_TC07(Method name) throws IOException, InterruptedException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.verifyUserMenuItems(),"User Menu items should be found");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"),"should be found");
		AssertJUnit.assertTrue(um.downloadLoginHistory(),"Download should be done");
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"),"should be found");
		AssertJUnit.assertTrue(um.removeTab("Chatter"),"Chatter should be removed");
		AssertJUnit.assertTrue(um.addTab("Chatter"),"Chatter should be added");
		AssertJUnit.assertTrue(um.verifyTab("Chatter_Tab"),"Chatter should be verified");
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"),"should be found");
		AssertJUnit.assertTrue(um.emailEdit(),"Email should be edited");
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"),"should be found");
		AssertJUnit.assertTrue(um.calendar_reminder(),"Activity reminder should be working");
		logger.info("******Ending test *********" +name.getName());
}
	
	@Test(priority=9)
	public static void developerConsole_TC08(Method name) throws IOException  {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.verifyUserMenuItems(),"User Menu items should be found");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("Developer Console"),"should be found");
		AssertJUnit.assertTrue(um.developerConsole(),"Developer concole should be opened");
		logger.info("******Ending test *********" +name.getName());
	}
	
	@Test(priority=10)
	public static void logout_TC09(Method name) throws IOException  {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.verifyUserMenuItems(),"User Menu items should be found");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("Logout"),"should be found");
		Utilities.waitForElement(driver, lp.username);
		AssertJUnit.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")), "Username should be entered");
		logger.info("******Ending test *********" +name.getName());
	}
}
	