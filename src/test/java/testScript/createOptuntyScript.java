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
		logger.info(name.getName()+" started");
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest(name.getName());
		LoginPage lp=new LoginPage(driver,test);
		CreateOptunty co=new CreateOptunty(driver,test);
		Assert.assertTrue(lp.loginToSFDC(), "Login should happen");
		co.oppTab.click();
		Utilities.waitForElement(driver, co.oppDropDown);
		co.oppDropDown.click();
		Assert.assertTrue(co.verifyOppDropDownItems(),"Items should be verified");
		Assert.assertTrue(co.selectOptionOppDropDown(3),"Option should be selected");
		logger.info(name.getName()+" started");
	}
}
