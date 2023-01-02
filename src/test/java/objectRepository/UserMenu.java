package objectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;

public class UserMenu extends BasePage{
	
	public UserMenu(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
		this.driver=driver;
	}

	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userMenu;
	
	@FindBy(xpath="//div[@id='userNav-menuitems']/a")
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath="//a[@title='My Profile']")
	public WebElement myProfile;
	
	@FindBy(xpath="//a[@title='My Settings']")
	public WebElement mySettings;
	
	@FindBy(xpath="//a[@title='Developer Console (New Window)']")
	public WebElement developerConsole;
	
	@FindBy(xpath="//a[@title='Switch to Lightning Experience']")
	public WebElement lightningExperience;
	
	@FindBy(xpath="//a[@title='Logout']")
	public WebElement logout;
	
	@FindBy(xpath="(//img[@title='Edit Profile'])[1]")
	public WebElement editProfile;
	
	@FindBy(xpath="//li[@id='aboutTab']")
	public WebElement aboutTab;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@value='Save All']")
	public WebElement saveAll;
	
	public boolean clickOnUserMenu() throws IOException {
		boolean userMenuSeen=true;
		if(userMenu.isDisplayed()) {
			userMenu.click();
			test.info("UserMenu clicked");
		}
		else {
			test.fail("userMenu not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			userMenuSeen=false;
		}
		return userMenuSeen;
	}
	
	public boolean verifyUserMenuItems() throws IOException {
		boolean isOptionVerified=true;
		String expectedMenuItems[]= { "My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience", "Logout" };
		for(int i=0;i<userMenuOptions.size();i++) {
			String actualMenuItemValue=userMenuOptions.get(i).getText();
			if(actualMenuItemValue.equalsIgnoreCase(expectedMenuItems[i])) {
				System.out.println(expectedMenuItems[i]+"Passed");
				test.info("Usermenu items verified");
			}
			else {
				isOptionVerified=false;
				test.fail("UserMenu items not found");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		return isOptionVerified;
	}
	
	public boolean selectOptionUserMenuDropDown(WebDriver driver, String optionName) throws IOException {
		boolean isOptionSelected=false;
		WebElement userMenuOption=driver.findElement(By.xpath("//*[text()='"+optionName+"']"));
		if(userMenuOption.isDisplayed()) {
			userMenuOption.click();
			isOptionSelected=true;
			test.info("Usermenu option selected");
		}
		else {
			System.out.println(userMenuOption+"is not selected");
			test.fail("Usermenu option not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isOptionSelected;
		
	}
}
