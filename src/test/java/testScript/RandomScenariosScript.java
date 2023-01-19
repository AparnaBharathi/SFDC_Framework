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
		AssertJUnit.assertTrue(lp.loginToSFDC());
		AssertJUnit.assertTrue(rs.validateUserName());
		logger.info("******Ending test *********" +name.getName());
	}
	
	@Test(priority=35)
	public static void myProfile_TC34(Method name) throws IOException, InterruptedException {
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
		logger.info("******Ending test *********" +name.getName());	
	}
	
	@Test(priority=36)
	public static void verifyTab_TC35(Method name) throws IOException  {
		logger.info(name.getName()+" -------started---------");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC());
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("My Settings"));
		AssertJUnit.assertTrue(um.removeTab("Chatter"));
		AssertJUnit.assertTrue(um.addTab("Chatter"));
		AssertJUnit.assertTrue(um.clickOnUserMenu());
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("Logout"));
		Utilities.waitForElement(driver, lp.username);
		AssertJUnit.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")));
		AssertJUnit.assertTrue(lp.enterPswd(DataUtils.readAccounts("valid.password")));
		AssertJUnit.assertTrue(lp.clickLogin());
		AssertJUnit.assertTrue(um.verifyTab("Chatter_Tab"));
	}
}
