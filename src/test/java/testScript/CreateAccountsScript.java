package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.CreateAccount;
import objectRepository.LoginPage;


public class CreateAccountsScript extends BaseTest{

	@Test(priority=11)
	public static void createAccount_TC10() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("createAccount_TC10");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		AssertJUnit.assertTrue("Login should be happened", lp.loginToSFDC());
		AssertJUnit.assertTrue("Account should be created",ca.createAcc());
}
	@Test(priority=12)
	public static void createNewView_TC11() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("createNewView_TC11");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		AssertJUnit.assertTrue("Login should be happened", lp.loginToSFDC());
		AssertJUnit.assertTrue("New view should be created",ca.createNewView());
	}
	
	@Test(priority=13)
	public static void editView_TC12() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("editView_TC12");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		AssertJUnit.assertTrue("Login should be happened", lp.loginToSFDC());
		AssertJUnit.assertTrue("View is should be edited",ca.editView());
	}
	
	@Test(priority=14)
	public static void mergeAcc_TC13() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("mergeAcc_TC13");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		AssertJUnit.assertTrue("Login should be happened", lp.loginToSFDC());
		AssertJUnit.assertTrue("Accounts should be merged",ca.mergeAccounts());
	}
	
	@Test(priority=15)
	public static void createAccReport_TC14() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("createAccReport_TC14");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		AssertJUnit.assertTrue("Login should be happened", lp.loginToSFDC());
		AssertJUnit.assertTrue("Reports should be created",ca.createAccountReports());
	}
}
	