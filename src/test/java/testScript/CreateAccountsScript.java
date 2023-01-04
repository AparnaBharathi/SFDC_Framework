package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.CreateAccount;
import objectRepository.LoginPage;
import objectRepository.UserMenu;

public class CreateAccountsScript extends BaseTest{

	@Test(priority=11)
	public static void createAccount_TC10() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("createAccount_TC10");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Assert.assertTrue(ca.createAcc(),"Account should be created");
}
	@Test(priority=12)
	public static void createNewView_TC11() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("createNewView_TC11");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Assert.assertTrue(ca.createNewView(),"New view should be created");
	}
	
	@Test(priority=13)
	public static void editView_TC12() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("editView_TC12");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Assert.assertTrue(ca.editView(),"View is should be edited");
	}
	
	@Test(priority=14)
	public static void mergeAcc_TC13() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("mergeAcc_TC13");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Assert.assertTrue(ca.mergeAccounts(),"Accounts should be merged");
	}
	
	@Test(priority=15)
	public static void createAccReport_TC14() throws IOException  {
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("createAccReport_TC14");
		LoginPage lp=new LoginPage(driver,test);
		CreateAccount ca=new CreateAccount(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should be happened");
		Assert.assertTrue(ca.createAccountReports(),"Reports should be created");
	}
}
	