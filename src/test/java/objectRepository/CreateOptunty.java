package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

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
	
	
	
	
}
