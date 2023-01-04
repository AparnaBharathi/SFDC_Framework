package objectRepository;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import utilities.Utilities;

public class CreateAccount extends BasePage{
	
	public CreateAccount(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
		this.driver=driver;
	}

	@FindBy(xpath="//li[@id='Account_Tab']")
	public WebElement accTab;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newAcc;
	
	@FindBy(xpath="//input[@id='acc2']")
	public WebElement accName;
	
	@FindBy(xpath="(//input[@value=' Save '])[1]")
	public WebElement save;
	
	@FindBy(xpath="//*[@id='filter_element']/div/span/span[2]/a[2]")
	public WebElement createNewView;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement viewName;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement viewUniqueName;
	
	@FindBy(xpath="//select[@class='title']")
	public WebElement titleView;
	
	@FindBy(xpath="//*[@id='filter_element']/div/span/span[2]/a[1]")
	public WebElement ediView;
	
	@FindBy(xpath="//a[@href='/merge/accmergewizard.jsp?retURL=%2F001%2Fo']")
	public WebElement mergeAcc;
	
	@FindBy(id="srch")
	public WebElement searchBox;
	
	@FindBy(xpath="//input[@value='Find Accounts']")
	public WebElement findAcc;
	
	@FindBy(id="cid0")
	public WebElement option1;
	
	@FindBy(id="cid1")
	public WebElement option2;
	
	@FindBy(xpath="(//input[@value=' Next '])[1]")
	public WebElement next;
	
	@FindBy(xpath="(//input[@value=' Merge '])[1]")
	public WebElement merge;
	
	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a")
	public WebElement activtyGreater30Days;
	
	@FindBy(id="ext-gen152")
	public WebElement fromDate;
	
	@FindBy(xpath="(//button[text()='Today'])[1]")
	public WebElement fromDateToday;
	
	@FindBy(id="ext-gen154")
	public WebElement toDate;
	
	@FindBy(xpath="(//button[text()='Today'])[2]")
	public WebElement toDateToday;
	
	@FindBy(id="ext-gen49")
	public WebElement saveReport;
	
	@FindBy(id="saveReportDlg_reportNameField")
	public WebElement reportName;
	
	@FindBy(id="saveReportDlg_DeveloperName")
	public WebElement uniqueReportName;
	
	@FindBy(xpath="(//button[@class=' x-btn-text'])[17]")
	public WebElement reportBtn;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement reportTitle;
	
	
	
	public boolean createAcc() throws IOException {
		Boolean isCreateAcc=false;
		accTab.click();
		Utilities.waitForElement(driver, newAcc);
		newAcc.click();
		Utilities.waitForElement(driver, accName);
		String id=RandomStringUtils.random(6, true, true);
		accName.sendKeys(id);
		save.click();
		String title=driver.getTitle();
		if(title.contains(id)) {
			isCreateAcc=true;
			test.info("Account created");
		}
		else {
			test.fail("Account not created");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isCreateAcc;
	}
	
	public boolean createNewView() throws IOException {
		Boolean isCreateNewView=false;
		accTab.click();
		Utilities.waitForElement(driver, createNewView);
		createNewView.click();
		Utilities.waitForElement(driver, viewName);
		String id=RandomStringUtils.random(6, true, true);
		viewName.sendKeys(id);
		viewUniqueName.click();
		save.click();
		Utilities.waitForElement(driver, titleView);
		String title=titleView.getText();
		if(title.contains(id)) {
			isCreateNewView=true;
			test.info("View created");
		}
		else {
			test.fail("view not created");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isCreateNewView;
	}
	
	public boolean editView() throws IOException {
		Boolean isEditView=false;
		accTab.click();
		Utilities.waitForElement(driver, ediView);
		ediView.click();
		Utilities.waitForElement(driver, viewName);
		viewName.clear();
		String id=RandomStringUtils.random(6, true, true);
		viewName.sendKeys(id);
		viewUniqueName.click();
		Select sa=new Select(driver.findElement(By.id("fcol1")));
		sa.selectByValue("ACCOUNT.NAME");
		Select s1=new Select(driver.findElement(By.id("fop1")));
		s1.selectByValue("c");
		Select s=new Select(driver.findElement(By.id("colselector_select_0")));
		s.selectByValue("ACCOUNT.LAST_ACTIVITY");
		driver.findElement(By.xpath("(//img[@title='Add'])[1]")).click();
		save.click();
		String title=titleView.getText();
		if(title.contains(id)) {
			isEditView=true;
			test.info("View edited");
		}
		else {
			test.fail("view not edited");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isEditView;
	}
	
	public boolean mergeAccounts() throws IOException {
		Boolean isMerge=false;
		accTab.click();
		Utilities.waitForElement(driver, mergeAcc);
		mergeAcc.click();
		Utilities.waitForElement(driver, searchBox);
		searchBox.sendKeys("XYZ");
		findAcc.click();
		Utilities.waitForElement(driver, option1);
		option1.click();
		option2.click();
		next.click();
		Utilities.waitForElement(driver, merge);
		if(merge.isDisplayed()) {
			merge.click();
			driver.switchTo().alert().accept();
			isMerge=true;
			test.info("Merged Accounts");
		}
		else {
			test.fail("Not merged");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isMerge;
	}
	
	public boolean createAccountReports() throws IOException {
		Boolean isReportCreated=false;
		accTab.click();
		Utilities.waitForElement(driver, activtyGreater30Days);
		activtyGreater30Days.click();
		Utilities.waitForElement(driver, fromDate);
		fromDate.click();
		Utilities.waitForElement(driver, fromDateToday);
		fromDateToday.click();
		Utilities.waitForElement(driver, toDate);
		toDate.click();
		Utilities.waitForElement(driver, toDateToday);
		toDateToday.click();
		saveReport.click();
		Set<String> windowID=driver.getWindowHandles();
		String parent=driver.getWindowHandle();
		String child="";
		java.util.Iterator<String> itr=windowID.iterator();
		while(itr.hasNext()) {
			//parent=itr.next();
			child=itr.next();
		}
		System.out.println(parent);
		System.out.println(child);
		driver.switchTo().window(child);
		Utilities.waitForElement(driver, reportName);
		String id=RandomStringUtils.random(5, true, false);
		reportName.sendKeys(id);
		uniqueReportName.click();
		Utilities.waitForElement(driver, reportBtn);
		reportBtn.click();
		driver.switchTo().window(parent);
		Utilities.waitForElement(driver, reportTitle);
		String title=reportTitle.getText();
		if(title.contains(id)) {
			test.info("Reportcreated");
			isReportCreated=true;
		}
		else {
			test.fail("Report Not created");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isReportCreated;
		
	}
	
}
