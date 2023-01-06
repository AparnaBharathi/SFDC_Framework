package objectRepository;

import java.io.IOException;
import java.util.List;

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

public class CreateOptunty extends BasePage{

	public CreateOptunty(WebDriver driver,ExtentTest test) {
		PageFactory.initElements(driver, this);
		this.test=test;
		this.driver=driver;
	}
	
	@FindBy(xpath="//li[@id='Opportunity_Tab']")
	public WebElement opTab;
	
	@FindBy(id="fcf")
	public WebElement opDropDown;
	
	@FindBy(xpath="//select[@id='fcf']/option")
	public List<WebElement> opDropDownOptions;
	
	@FindBy(xpath="//input[@value=' New ']")
	public WebElement newOp;
	
	@FindBy(xpath="//input[@id='opp3']")
	public WebElement opName;
	
	@FindBy(xpath="//a[@tabindex='7']")
	public WebElement closeDate;
	
	@FindBy(xpath="(//input[@value=' Save '])[1]")
	public WebElement opSave;
	
	@FindBy(xpath="//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement opTitle;
	
	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")
	public WebElement opStuckReport;
	
	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")
	public WebElement opPipelin;
	
	@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
	public WebElement pipeTitle;
	
	@FindBy(xpath="//select[@id='quarter_q']")
	public WebElement interval;
	
	@FindBy(xpath="//select[@id='open']")
	public WebElement include;
	
	@FindBy(xpath="//input[@value='Run Report']")
	public WebElement runReport;
	
	
	
	public boolean verifyOpDropDownItems() throws IOException {
		boolean isOptionVerified=false;
		String expectedOpItems[]= DataUtils.readAccounts("oppdropdown.items").split(",");
		for(int i=0;i<opDropDownOptions.size();i++) {
			String actualMenuItemValue=opDropDownOptions.get(i).getText();
			//System.out.println("Actual" +actualMenuItemValue);
			if(actualMenuItemValue.equalsIgnoreCase(expectedOpItems[i])) {
				//System.out.println(expectedOpItems[i]+"Passed");
				logger.info(actualMenuItemValue+"verified");
				test.info("Usermenu items verified");
				isOptionVerified=true;
			}
			else {
				isOptionVerified=false;
				test.fail("UserMenu items not found");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		return isOptionVerified;
	}
	
	public boolean selectOptionOpDropDown(int optionNum) throws IOException {
		boolean isOptionSelected=false;
		WebElement opOption=driver.findElement(By.xpath("//*[@id='fcf']/option["+optionNum+"]"));
		if(opOption.isDisplayed()) {
			logger.info(opOption+"******is displayed******");
			opOption.click();
			isOptionSelected=true;
			test.info("Usermenu option selected");
		}
		else {
			System.out.println(opOption+"is not selected");
			test.fail("Usermenu option not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isOptionSelected;
		
	}
	
	public boolean createNewOp() throws IOException {
		boolean isNewOpCreated=false;
		Utilities.waitForElement(driver, newOp);
		if(newOp.isDisplayed()) {
			newOp.click();
			Utilities.waitForElement(driver, opName);
			if(opName.isDisplayed()) {
				String id=RandomStringUtils.random(5, true, false);
				opName.sendKeys(id);
				closeDate.click();
				Select s=new Select(driver.findElement(By.xpath("//select[@id='opp11']")));
				s.selectByIndex(3);
				opSave.click();
				Utilities.waitForElement(driver, opTitle);
				String actual=opTitle.getText();
				if(actual.contains(id)) {
					logger.info("New Oportunity created and verified");
					test.info("New Oportunity created and verified");
					isNewOpCreated=true;
				}
				else {
					test.fail("New oportunity not created");
					logger.error("New oportunity not created");
					test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
				}
			}
		}
			else {
				test.fail("New Oportunity button not found");
			}
			return isNewOpCreated;
	}
	
	public boolean opPipeline() throws IOException {
		boolean isOpPipeVerified=false;
		Utilities.waitForElement(driver, opPipelin);
		if(opPipelin.isDisplayed()) {
			opPipelin.click();
			test.info("Opportunities pipeline clicked");
			Utilities.waitForElement(driver, pipeTitle);
			String actual=pipeTitle.getText();
			if(actual.contains("Opportunity")) {
				logger.info("Opportunity pipeline verified");
				test.info("Opportunity pipeline verified");
				isOpPipeVerified=true;
			}
			else {
				test.fail("Opportunity pipeline not verified");
				logger.error("Opportunity pipeline not verified");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		else {
			test.fail("Opportunity pipeline not available");
			logger.error("Opportunity pipeline not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isOpPipeVerified;
	}
	
	public boolean opStuckReport() throws IOException {
		boolean isOpStuckVerified=false;
		Utilities.waitForElement(driver, opStuckReport);
		if(opStuckReport.isDisplayed()) {
			opStuckReport.click();
			test.info("Opportunities stuck report clicked");
			Utilities.waitForElement(driver, pipeTitle);
			String actual=pipeTitle.getText();
			if(actual.contains("Stuck")) {
				logger.info("Opportunity Stuck report verified");
				test.info("Opportunity Stuck report verified");
				isOpStuckVerified=true;
			}
			else {
				test.fail("Opportunity Stuck report not verified");
				logger.error("Opportunity Stuck report not verified");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		else {
			test.fail("Opportunity Stuck report not available");
			logger.error("Opportunity Stuck report not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isOpStuckVerified;
	}
	
	public boolean quatSummaryReport() throws IOException {
		boolean isquatreport=false;
		Utilities.waitForElement(driver, interval);
		if(interval.isDisplayed()) {
			Select s=new Select(interval);
			s.selectByValue("curnext1");
			Select s1=new Select(include);
			s1.selectByValue("open");
			runReport.click();
			Utilities.waitForElement(driver, pipeTitle);
			String actual=pipeTitle.getText();
			if(actual.contains("Report")) {
				logger.info("Quaterly report report verified");
				test.info("Quaterly report report verified");
				isquatreport=true;
			}
			else {
				test.fail("Quaterly report not verified");
				logger.error("Quaterly report not verified");
				test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			}
		}
		else {
			test.fail("Quaterly report not available");
			logger.error("Quaterly report not available");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isquatreport;
	}
	
}
