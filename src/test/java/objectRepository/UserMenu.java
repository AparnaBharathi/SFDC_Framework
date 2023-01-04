package objectRepository;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import utilities.DataUtils;
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
	
	@FindBy(id="PersonalInfo_font")
	public WebElement personalLink;
	
	@FindBy(xpath="//span[@id='LoginHistory_font']")
	public WebElement loginHistory;
	
	@FindBy(xpath="//*[@id='RelatedUserLoginHistoryList_body']/div/a")
	public WebElement downloadHistory;
	
	@FindBy(id="DisplayAndLayout_font")
	public WebElement displayLayout;
	
	@FindBy(xpath="//span[@id='CustomizeTabs_font']")
	public WebElement customizeTab;
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	public WebElement selectedTabs;
	
	@FindBy(id="duel_select_0_left")
	public WebElement removeTab;
	
	@FindBy(xpath="(//input[@value=' Save '])[1]")
	public WebElement save;
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement availableTabs;
	
	@FindBy(id="duel_select_0_right")
	public WebElement addTab;
	
	@FindBy(id="EmailSetup_font")
	public WebElement email;
	
	@FindBy(xpath="//span[@id='EmailSettings_font']")
	public WebElement emailSettings;
	
	@FindBy(xpath="//input[@id='sender_name']")
	public WebElement senderName;
	
	@FindBy(xpath="//input[@id='sender_email']")
	public WebElement senderEmail;
	
	@FindBy(xpath="//input[@id='auto_bcc1']")
	public WebElement auto_bcc;
	
	@FindBy(id="CalendarAndReminders_font")
	public WebElement calendar;
	
	@FindBy(xpath="//span[@id='Reminders_font']")
	public WebElement activityReminder;
	
	@FindBy(xpath="//input[@id='testbtn']")
	public WebElement testReminder;
	
	@FindBy(xpath="//input[@id='dismiss_all']")
	public WebElement dismissAll;
	
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
		String expectedMenuItems[]= DataUtils.readAccounts("usermenu.tems").split(",");
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
	
	public boolean selectOptionUserMenuDropDown(String optionName) throws IOException {
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
	
	public boolean downloadLoginHistory() throws IOException {
		boolean isDownloadDone=false;
		Utilities.waitForElement(driver, personalLink);
		if(personalLink.isDisplayed()) {
			personalLink.click();
			loginHistory.click();
			downloadHistory.click();
			test.info("Download completed");
			isDownloadDone=true;
		}
		else {
			test.fail("Download not done");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isDownloadDone;
	}
	
	public boolean removeTab(String tabName) throws IOException {
		Utilities.waitForElement(driver, displayLayout);
		displayLayout.click();
		Utilities.waitForElement(driver, customizeTab);
		customizeTab.click();
		Utilities.waitForElement(driver, selectedTabs);
		boolean isTabRemoved=true;
		if(selectedTabs.isDisplayed()) {
			Select s=new Select(selectedTabs);
			s.selectByValue(tabName);
			removeTab.click();
			save.click();
			test.info("Tab removed");
		}
		else {
			System.out.println(selectedTabs +"is not selected");
			test.fail("Usermenu option not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			isTabRemoved=false;
		}
		return isTabRemoved;
		}
	
	public boolean addTab(String tabName) throws IOException {
		Utilities.waitForElement(driver, displayLayout);
		displayLayout.click();
		Utilities.waitForElement(driver, customizeTab);
		customizeTab.click();
		Utilities.waitForElement(driver, availableTabs);
		boolean isTabAdded=true;
		if(availableTabs.isDisplayed()) {
			Select s=new Select(availableTabs);
			s.selectByValue(tabName);
			addTab.click();
			save.click();
			test.info("Tab added");
		}
		else {
			System.out.println(selectedTabs +"is not selected");
			test.fail("Usermenu option not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			isTabAdded=false;
		}
		return isTabAdded;
		}
	
	public boolean verifyTab(String tabName) throws IOException {
		boolean tabAvailable=false;
		WebElement checkTab=driver.findElement(By.xpath("//*[@id='"+tabName+"']"));
		if(checkTab.isDisplayed()) {
			tabAvailable=true;
			test.info("Tab availble");
		}
		else {
			test.fail("Tab not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return tabAvailable;
	}
	
	public boolean emailEdit() throws IOException {
		boolean isEmailEdited=false;
		Utilities.waitForElement(driver, email);
		if(email.isDisplayed()) {
			email.click();
			emailSettings.click();
			Utilities.waitForElement(driver, senderName);
			senderName.clear();
			senderName.sendKeys("Aparna");
			senderEmail.clear();
			senderEmail.sendKeys("aparnbharathiit@gmail.com");
			auto_bcc.click();
			save.click();
			driver.switchTo().alert().accept();
			test.info("email edited");
			isEmailEdited=true;
		}
		else {
			test.fail("Email not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isEmailEdited;
	}
	
	public boolean calendar_reminder() throws InterruptedException, IOException {
		boolean isCalenderTested=false;
		if(calendar.isDisplayed()) {
			calendar.click();
			activityReminder.click();
			testReminder.click();
			Thread.sleep(3000);
			Set<String> windowID=driver.getWindowHandles();
			String tab1="";
			String tab2="";
			java.util.Iterator<String> itr=windowID.iterator();
			while(itr.hasNext()) {
				tab1=itr.next();
				tab2=itr.next();
			}
			driver.switchTo().window(tab2);
			Utilities.waitForElement(driver, dismissAll);
			dismissAll.click();
			isCalenderTested=true;
			test.info("Activity reminder tested");
		}
		else {
			test.fail("Calendar not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isCalenderTested;
	}
	
	public Boolean developerConsole() throws IOException {
		boolean isdeveloperConsoleSeen=true;
		if(isdeveloperConsoleSeen) {
			String child=(String) driver.getWindowHandle();
			//System.out.println(child);
			WebDriver d=driver.switchTo().window(child);
			String title=driver.getTitle();
			//System.out.println(title);
			String expected="Home Page ~ Salesforce - Developer Edition";
			Assert.assertEquals(title, expected);
			test.info("Developer console opened");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		else {
			isdeveloperConsoleSeen=false;
			test.fail("Calendar not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isdeveloperConsoleSeen;
	}
}
