package testScript;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.LoginPage;
import objectRepository.RandomScenrios;
import objectRepository.UserMenu;
import utilities.DataUtils;
import utilities.Utilities;

public class RandomScenariosScript extends BaseTest {

	@Test(priority=34)
	public static void verifyName_TC33(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		RandomScenrios rs=new RandomScenrios(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(rs.validateUserName(), "Username should be validated");
		logger.info("******Ending test *********" +name.getName());
	}
	
	@Test(priority=35)
	public static void myProfile_TC34(Method name) throws IOException, InterruptedException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Utilities.waitForElement(driver, um.userMenu);
		Assert.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		Assert.assertTrue(um.verifyUserMenuItems(),"User Menu items should be found");
		Assert.assertTrue(um.selectOptionUserMenuDropDown("My Profile"),"should be found");
		Thread.sleep(3000);
		Utilities.waitForElement(driver, um.editProfile);
		Assert.assertTrue(um.editProf(),"Profile name should be edited");
		logger.info("******Ending test *********" +name.getName());	
	}
	
	@Test(priority=36)
	public static void verifyTab_TC35(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		Assert.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		Assert.assertTrue(um.selectOptionUserMenuDropDown("My Settings"),"should be found");
		Assert.assertTrue(um.removeTab("Chatter"),"Chatter should be removed");
		Assert.assertTrue(um.addTab("Chatter"),"Chatter should be added");
		Assert.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		Assert.assertTrue(um.selectOptionUserMenuDropDown("Logout"),"should be found");
		Utilities.waitForElement(driver, lp.username);
		Assert.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")),"Username should be entered");
		Assert.assertTrue(lp.enterPswd(DataUtils.readAccounts("valid.password")),"Pswd should be entered");
		Assert.assertTrue(lp.clickLogin(),"Login should be clicked");
		Assert.assertTrue(um.verifyTab("Chatter_Tab"),"Chatter should be verified");
	}
}
