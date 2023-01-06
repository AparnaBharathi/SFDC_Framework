package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utilities.DataUtils;
import utilities.Utilities;

public class RandomScenrios extends BasePage{
	
	public RandomScenrios(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
		this.driver=driver;
	}

	@FindBy(linkText="Home")
	public WebElement homeTab;
	
	@FindBy(xpath="//h1[@class='currentStatusUserName']")
	public WebElement userName;
	
	public boolean validateUserName() throws IOException {
		boolean isValidateName=false;
		Utilities.waitForElement(driver, homeTab);
		if(homeTab.isDisplayed()) {
			homeTab.click();
			Utilities.waitForElement(driver, userName);
			String actual=userName.getText();
			String expected=DataUtils.readAccounts("username.title");
			if(actual.equals(expected))
			{
				isValidateName=true;
				test.info("Username verified");
				logger.info("Username verified");
			}
			else {
				test.fail("Username not verified");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		return isValidateName;
	}
}
