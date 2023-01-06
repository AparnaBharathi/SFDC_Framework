package objectRepository;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import utilities.DataUtils;
import utilities.Utilities;

public class Leads extends BasePage{

	public Leads(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[@title='Leads Tab']")
	public WebElement leadsTab;
	
	@FindBy(xpath="(//img[@title='Lead'])[2]")
	public WebElement leadsTitle;
	
	@FindBy(xpath="//select[@id='fcf']/option")
	public List<WebElement> leadsDropDownOptions;
	
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement view;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newLead;
	
	@FindBy(xpath="//input[@id='name_lastlea2']")
	public WebElement lastNmae;
	
	@FindBy(xpath="//input[@id='lea3']")
	public WebElement company;
	
	@FindBy(xpath="(//input[@value=' Save '])[2]")
	public WebElement save;
	
	@FindBy(xpath="//h2[@class='topName']")
	public WebElement title;
	
	
	
	public boolean clickOnLeads() throws IOException {
		boolean isclickLeads=false;
		Utilities.waitForElement(driver, leadsTab);
		if(leadsTab.isDisplayed()) {
			leadsTab.click();
			Utilities.waitForElement(driver, leadsTitle);
			if(leadsTitle.isDisplayed()) {
				isclickLeads=true;
				test.info("Leads clicked and verified");
				logger.info("Leads clicked and verified");
			}
			else {
				test.fail("Leads not verified");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		else {
			test.fail("Leads not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isclickLeads;
		}
	
	public boolean verifyLeadsDropDownItems() throws IOException {
		boolean isOptionVerified=false;
		String expectedOpItems[]= DataUtils.readAccounts("leadsdropdown.items").split(",");
		for(int i=0;i<leadsDropDownOptions.size();i++) {
			String actualMenuItemValue=leadsDropDownOptions.get(i).getText();
			if(actualMenuItemValue.equalsIgnoreCase(expectedOpItems[i])) {
				logger.info(actualMenuItemValue+"verified");
				test.info("Usermenu items verified");
				isOptionVerified=true;
			}
			else {
				isOptionVerified=false;
				test.fail("Leads menu items not found");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		return isOptionVerified;
	}
	
	public void selectOptionLeadsDropDown(String visibleText) throws IOException {
		Select s=new Select(view);
		s.selectByVisibleText(visibleText);
		test.info("View option selected");
	}
	
	public boolean validateDefaultOption(String visibleText) throws IOException {
		boolean isDefault=false;
		Select s=new Select(view);
		WebElement actual=s.getFirstSelectedOption();
		String actual1=actual.getText();
		if(actual1.equals(visibleText)) {
			test.info("Default value passed");
			logger.info("Default value passed");
			isDefault=true;
		}
		else {
			test.fail("Default value failed");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isDefault;
	}
	
	public boolean newwLead() throws IOException {
		boolean isNewLead=false;
		if(newLead.isDisplayed()) {
			newLead.click();
			Utilities.waitForElement(driver, lastNmae);
			lastNmae.sendKeys("ABCD");
			company.sendKeys("Abc");
			save.click();
			Utilities.waitForElement(driver, title);
			String actual=title.getText();
			if(actual.equals("ABCD")) {
				test.info("New Lead created");
				logger.info("New Lead created");
				isNewLead=true;
			}
			else {
				test.fail("New lead not created");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
			return isNewLead;
			}
		}
	
