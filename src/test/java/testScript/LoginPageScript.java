package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.LoginPage;
import objectRepository.UserMenu;
import utilities.DataUtils;
import utilities.Utilities;

public class LoginPageScript extends BaseTest{

	@Test(priority=1)
	public static void loginErrorMsg_TC01() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("loginErrorMsg_TC01");
		LoginPage lp=new LoginPage(driver,test);
		Assert.assertTrue(lp.launchApp(driver), "App is not launched");
		Assert.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")), "Username not entered");
		Assert.assertTrue(lp.clearPasswd(), "Password not cleared");
		Assert.assertTrue(lp.clickLogin(), "Login not clicked");
		Utilities.waitForElement(driver, lp.loginError);
		Assert.assertEquals(lp.getErrorMsg(), DataUtils.readExpectedError("blank.password"));
	}
	
	@Test(priority=2)
	public static void login_TC02() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("login_TC02");
		LoginPage lp=new LoginPage(driver,test);
		Assert.assertTrue(lp.launchApp(driver), "App is not launched");
		Assert.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")), "Username not entered");
		Assert.assertTrue(lp.enterPswd(DataUtils.readAccounts("valid.password")), "Password not entered");
		Assert.assertTrue(lp.clickLogin(), "Login not clicked");
		Assert.assertTrue(lp.isFreeTrialSeen(), "Free trial not seen");
		
	}
	
	@Test(priority=3)
	public static void rememberMe_TC03() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("rememberMe_TC03");
		LoginPage lp=new LoginPage(driver,test);
		UserMenu um=new UserMenu(driver,test);
		Assert.assertTrue(lp.launchApp(driver), "App is not launched");
		Assert.assertTrue(lp.enterUsername(DataUtils.readAccounts("valid.username")), "Username not entered");
		Assert.assertTrue(lp.enterPswd(DataUtils.readAccounts("valid.password")), "Password not entered");
		Assert.assertTrue(lp.rememberMe(), "RemeberMe not clicked");
		Assert.assertTrue(lp.clickLogin(), "Login not clicked");
		Utilities.waitForElement(driver, um.userMenu);
		Assert.assertTrue(um.clickOnUserMenu(), "User Menu not clicked");
		Assert.assertTrue(um.selectOptionUserMenuDropDown(driver, "Logout"), "Logut not clicked");
		Utilities.waitForElement(driver, lp.savedUser);
		Assert.assertEquals(lp.getSavedUser(), DataUtils.readAccounts("valid.username"));
	}
	
	@Test(priority=4)
	public static void forgorPswd_TC04A() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("forgorPswd_TC04A");
		LoginPage lp=new LoginPage(driver,test);
		Assert.assertTrue(lp.launchApp(driver), "App is not launched");
		Assert.assertTrue(lp.clickOnForgotPswd(), "Forgot pswd not clicked");
		Utilities.waitForElement(driver, lp.forgotPswdTitile);
		Assert.assertEquals(lp.verifyForgotPswdTitle(), "Forgot Your Password");
	}
	
	@Test(priority=5)
	public static void invalidCredentials_TC04B() throws IOException {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("invalidCredentials_TC04B");
		LoginPage lp=new LoginPage(driver,test);
		Assert.assertTrue(lp.launchApp(driver), "App is not launched");
		Assert.assertTrue(lp.enterUsername(DataUtils.readAccounts("invalid.username")), "Username not entered");
		Assert.assertTrue(lp.enterPswd(DataUtils.readAccounts("invalid.password")), "Password not entered");
		Assert.assertTrue(lp.clickLogin(), "Login not clicked");
		Assert.assertEquals(lp.getErrorMsg(), DataUtils.readExpectedError("wrong.unamepswd"));
	}
}
