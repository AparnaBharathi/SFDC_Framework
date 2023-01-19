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

public class LoginPageScript extends BaseTest{

	@Test(priority=1)
	public static void loginErrorMsg_TC01(Method name) throws IOException {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		logger.info("Started test " +name.getName());
		LoginPage lp=new LoginPage(driver,test);
		AssertJUnit.assertTrue(lp.launchApp(driver), "App should be launched");
		AssertJUnit.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")), "Username not entered");
		AssertJUnit.assertTrue(lp.clearPasswd(), "Password should be cleared");
		AssertJUnit.assertTrue(lp.clickLogin(), "Login should be clicked");
		Utilities.waitForElement(driver, lp.loginError);
		AssertJUnit.assertEquals(lp.getErrorMsg(), DataUtils.readExpectedError("blank.password"));
		logger.info("******Ending test *********" +name.getName());
	}
	
	@Test(priority=2)
	public static void login_TC02(Method name) throws IOException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		AssertJUnit.assertTrue(lp.loginToSFDC(), "Login should happen");
		AssertJUnit.assertTrue(lp.isFreeTrialSeen(), "Free trial should be seen");
		logger.info("******Ending test ********* " +name.getName());
		
	}
	
	@Test(priority=3)
	public static void rememberMe_TC03(Method name) throws IOException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		AssertJUnit.assertTrue(lp.launchApp(driver), "App should be launched");
		AssertJUnit.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")), "Username should be entered");
		AssertJUnit.assertTrue(lp.enterPswd(DataUtils.readAccounts("valid.password")), "Password should be entered");
		AssertJUnit.assertTrue(lp.rememberMe(), "RemeberMe should be clicked");
		AssertJUnit.assertTrue(lp.clickLogin(), "Login should be clicked");
		Utilities.waitForElement(driver, um.userMenu);
		AssertJUnit.assertTrue(um.clickOnUserMenu(), "User Menu should be clicked");
		AssertJUnit.assertTrue(um.selectOptionUserMenuDropDown("Logout"), "Logut should be clicked");
		Utilities.waitForElement(driver, lp.savedUser);
		AssertJUnit.assertEquals(lp.getSavedUser(), DataUtils.readAccounts("valid.username"));
		logger.info("******Ending test ********* " +name.getName());
	}
	
	@Test(priority=4)
	public static void forgorPswd_TC04A(Method name) throws IOException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		AssertJUnit.assertTrue(lp.launchApp(driver), "App should be launched");
		AssertJUnit.assertTrue(lp.clickOnForgotPswd(), "Forgot pswd should be clicked");
		Utilities.waitForElement(driver, lp.forgotPswdTitile);
		AssertJUnit.assertEquals(lp.verifyForgotPswdTitle(), "Forgot Your Password");
		logger.info("******Ending test ********* " +name.getName());
	}
	
	@Test(priority=5)
	public static void invalidCredentials_TC04B(Method name) throws IOException {
		logger.info("Started test " +name.getName());
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		AssertJUnit.assertTrue(lp.launchApp(driver), "App should be launched");
		AssertJUnit.assertTrue(lp.enterUsername(DataUtils.readAccounts("invalid.username")), "Username should be entered");
		AssertJUnit.assertTrue(lp.enterPswd(DataUtils.readAccounts("invalid.password")), "Password should be entered");
		AssertJUnit.assertTrue(lp.clickLogin(), "Login should be clicked");
		AssertJUnit.assertEquals(lp.getErrorMsg(), DataUtils.readExpectedError("wrong.unamepswd"));
		logger.info("******Ending test *********" +name.getName());
	}
}
