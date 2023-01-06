package objectRepository;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import utilities.DataUtils;
import utilities.Utilities;

public class Contacts extends BasePage {

	public Contacts(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
		this.driver=driver;
	}
	
	@FindBy(id="Contact_Tab")
	public WebElement contacts_tab;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement contactNew;
	
	@FindBy(xpath="//input[@id='name_lastcon2']")
	public WebElement lastName;
	
	@FindBy(xpath="(//input[@value=' Save '])[1]")
	public WebElement contactSave;
	
	@FindBy(xpath="//h2[@class='topName']")
	public WebElement contactTitle;
	
	@FindBy(xpath="//*[@id='filter_element']/div/span/span[2]/a[2]")
	public WebElement contactsNewView;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement contactViewName;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement contactViewUniqueName;
	
	@FindBy(xpath="//select[@name='fcf']")
	public WebElement contactDropDown;
	
	@FindBy(xpath="//select[@id='hotlist_mode']")
	public WebElement recentlyCreatedDropDown;
	
	@FindBy(xpath="//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[4]/th/a")
	public WebElement contactName;
	
	@FindBy(xpath="(//div[@class='errorMsg'])[1]")
	public WebElement viewError;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public WebElement cancelView;
	
	@FindBy(xpath="//h2[@class='pageDescription']")
	public WebElement conHomeTitile;
	
	@FindBy(xpath="(//input[@value='Save & New'])[1]")
	public WebElement saveNNew;
	
	
	
	public boolean createNewContact() throws IOException {
		boolean isCreateContact=false;
		Utilities.waitForElement(driver, contactNew);
		if(contactNew.isDisplayed()) {
			contactNew.click();
			Utilities.waitForElement(driver, lastName);
			if(lastName.isDisplayed()) {
				String name=RandomStringUtils.random(5, true, false);
				lastName.sendKeys(name);
				contactSave.click();
				Utilities.waitForElement(driver, contactTitle);
				String actual=contactTitle.getText();
				if(actual.contains(name)) {
					isCreateContact=true;
					test.info("New contact created and verified");
					logger.info("New contact created and verified");
				}
				else {
					test.fail("Contact not verified");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				}
			}
			}
			else {
				test.fail("New contact button not found");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
			return isCreateContact;
			}
	
	public boolean createNewContactView() throws IOException {
		boolean isCreateContactView=false;
		Utilities.waitForElement(driver, contactsNewView);
		if(contactsNewView.isDisplayed()) {
			contactsNewView.click();
			Utilities.waitForElement(driver, contactViewName);
			if(contactViewName.isDisplayed()) {
				String name=RandomStringUtils.random(5, true, false);
				contactViewName.sendKeys(name);
				contactViewUniqueName.click();
				contactSave.click();
				Utilities.waitForElement(driver, contactDropDown);
				String actual=contactDropDown.getText();
				if(actual.contains(name)) {
					isCreateContactView=true;
					test.info("New contact view created and verified");
					logger.info("New contact view created and verified");
				}
				else {
					test.fail("Contact view not verified");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				}
			}
			}
			else {
				test.fail("New view button not found");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
			return isCreateContactView;
			}
	
	public boolean recentlyCreated() throws IOException {
		boolean isRecent=false;
		Utilities.waitForElement(driver, recentlyCreatedDropDown);
		if(recentlyCreatedDropDown.isDisplayed()) {
			Select s=new Select(recentlyCreatedDropDown);
			s.selectByValue("3");
			isRecent=true;
			test.info("Recent contact verified");
			logger.info("Recent contact verified");
		}
		else {
			test.fail("Recent contact not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isRecent;
		
	}
	
	public boolean myConView() throws IOException {
		boolean isMyConView=false;
		Utilities.waitForElement(driver, contactDropDown);
		if(contactDropDown.isDisplayed()) {
			Select s=new Select(contactDropDown);
			s.selectByValue("00BDn000007PUna");
			Utilities.waitForElement(driver, contactDropDown);
			String selected=s.getFirstSelectedOption().getText();
			if(selected.equals("My Contacts")) {
				isMyConView=true;
				test.info("My Contact view verified");
				logger.info("My contact view verified");
			}
			else {
				test.fail("My contact view not viewd");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
			return isMyConView;
			
		}
	
	public boolean viewCon() throws IOException {
		boolean isViewCon=false;
		Utilities.waitForElement(driver, contactName);
		if(contactName.isDisplayed()) {
			String expected=contactName.getText();
			contactName.click();
			Utilities.waitForElement(driver, contactTitle);
			String name=contactTitle.getText();
			if(name.equals(expected)) {
				isViewCon=true;
				test.info("Contact viewed and verified");
				logger.info("Contact viewed and  verified");
			}
			else {
				test.fail("Contact not viewd");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
			return isViewCon;
	}
	
	public boolean createNewViewError() throws IOException {
		boolean isCreateViewError=false;
		Utilities.waitForElement(driver, contactsNewView);
		if(contactsNewView.isDisplayed()) {
			contactsNewView.click();
			Utilities.waitForElement(driver, contactViewName);
			if(contactViewName.isDisplayed()) {
				contactViewUniqueName.sendKeys("ABC");
				contactSave.click();
				Utilities.waitForElement(driver, viewError);
				String actual=viewError.getText();
				if(actual.contains(DataUtils.readExpectedError("empty.viewname"))) {
					isCreateViewError=true;
					test.info("Error message verified");
					logger.info("Error message verified");
				}
				else {
					test.fail("Error message not verified");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				}
			}
			}
			return isCreateViewError;
			}
	
	public boolean cancelView() throws IOException {
		boolean isCancelView=false;
		Utilities.waitForElement(driver, contactsNewView);
		if(contactsNewView.isDisplayed()) {
			contactsNewView.click();
			Utilities.waitForElement(driver, contactViewName);
			if(contactViewName.isDisplayed()) {
				contactViewName.sendKeys("ABCD");
				contactViewUniqueName.click();
				cancelView.click();
				Utilities.waitForElement(driver, conHomeTitile);
				String actual=conHomeTitile.getText();
				if(actual.contains("Home")) {
					isCancelView=true;
					test.info("Cancelview working");
					logger.info("Cancelview working");
				}
				else {
					test.fail("Cancelview not working");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				}
			}
			}
			else {
				test.fail("Cancelview not working");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
			return isCancelView;
			}
	
	public boolean saveandNewButton() throws IOException {
		boolean isSaveandNew=false;
		Utilities.waitForElement(driver, contactNew);
		if(contactNew.isDisplayed()) {
			contactNew.click();
			Utilities.waitForElement(driver, lastName);
			if(lastName.isDisplayed()) {
				String name=RandomStringUtils.random(5, true, false);
				lastName.sendKeys(name);
				saveNNew.click();
				Utilities.waitForElement(driver, conHomeTitile);
				String actual=conHomeTitile.getText();
				if(actual.contains("New Contact")) {
					isSaveandNew=true;
					test.info("Save and New button verified");
					logger.info("Save and New button  verified");
				}
				else {
					test.fail("Save and New button not verified ");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				}
			}
			}
			else {
				test.fail("New contact button not found");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
			return isSaveandNew;
			}
	
}
