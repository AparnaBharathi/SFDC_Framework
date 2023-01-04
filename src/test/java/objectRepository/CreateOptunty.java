package objectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	public WebElement oppTab;
	
	@FindBy(id="fcf")
	public WebElement oppDropDown;
	
	@FindBy(xpath="//select[@id='fcf']/option")
	public List<WebElement> oppDropDownOptions;
	
	public boolean verifyOppDropDownItems() throws IOException {
		boolean isOptionVerified=true;
		String expectedOppItems[]= DataUtils.readAccounts("oppdropdown.items").split(",");
		for(int i=0;i<oppDropDownOptions.size();i++) {
			String actualMenuItemValue=oppDropDownOptions.get(i).getText();
			//System.out.println("Actual" +actualMenuItemValue);
			if(actualMenuItemValue.equalsIgnoreCase(expectedOppItems[i])) {
				//System.out.println(expectedOppItems[i]+"Passed");
				logger.info(actualMenuItemValue+"verified");
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
	
	public boolean selectOptionOppDropDown(int optionNum) throws IOException {
		boolean isOptionSelected=false;
		WebElement oppOption=driver.findElement(By.xpath("//*[@id='fcf']/option["+optionNum+"]"));
		if(oppOption.isDisplayed()) {
			logger.info(oppOption+"******is displayed******");
			oppOption.click();
			isOptionSelected=true;
			test.info("Usermenu option selected");
		}
		else {
			System.out.println(oppOption+"is not selected");
			test.fail("Usermenu option not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return isOptionSelected;
		
	}
	
	
	
}
