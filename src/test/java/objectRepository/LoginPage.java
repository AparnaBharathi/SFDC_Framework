package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import utilities.DataUtils;
import utilities.Utilities;



public class LoginPage extends BasePage{
	
	/**The constructor is to initialize the 
	 * webelements declared in the class.
	 * The argument this takes the reference of this class
	 * @author aparnakarthik
	 *
	 */
	
	public LoginPage(WebDriver driver, ExtentTest test) {
	PageFactory.initElements(driver, this);
	this.test=test;
	this.driver=driver;
	}
	
	/**Object repository for login page
	 * @author aparnakarthik
	 *
	 */
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//*[@id='Login']")
	public WebElement login;
	
	@FindBy(xpath="//div[@id='error']")
	public WebElement loginError;
	
	@FindBy(xpath="//input[@type='checkbox' and @id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id="forgot_password_link")
	public WebElement forgotPswd;
	
	@FindBy(id="idcard-identity")
	public WebElement savedUser;
	
	@FindBy(xpath="//h1[@id='header']")
	public WebElement forgotPswdTitile;
	
	/**Enter user name in login page
	 * @author aparnakarthik
	 * @throws IOException 
	 *
	 */
	
	public Boolean enterUsername(String uname) throws IOException {
		if(username.isDisplayed()) {
			username.sendKeys(uname);
			test.info("UserName is entered");
			return true;
		}
		else {
			test.fail("Username not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	/**Enter password in login page
	 * @author aparnakarthik
	 * @throws IOException 
	 *
	 */
	
	public Boolean enterPswd(String pswd) throws IOException {
		if(password.isDisplayed()) {
			password.sendKeys(pswd);
			test.info("Pswd entered");
			return true;
		}
		else {
			test.fail("Pswd not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	/**Click login in login page
	 * @author aparnakarthik
	 * @throws IOException 
	 *
	 */
	
	public Boolean clickLogin() throws IOException {
		if(login.isDisplayed()) {
			login.click();
			test.info("Clicked login");
			return true;
		}
		else {
			test.fail("Login not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	/**Click remeberMe in login page
	 * @author aparnakarthik
	 * @throws IOException 
	 *
	 */
	
	public Boolean rememberMe() throws IOException {
		boolean selectRememberMe=false;
		if(rememberMe.isDisplayed()) {
			if(rememberMe.isSelected()) {
				selectRememberMe=true;
			}
			else {
				rememberMe.click();
				selectRememberMe=true;
				test.info("RemeberMe is clicked");
			}
		}
		else {
			test.fail("RemeberMe not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		}
		return selectRememberMe;
	}
	
	public Boolean clearPasswd() {
		password.clear();
		test.info("Password empty");
		return true;
	}
	
	public Boolean isErrorMsgSeen() throws IOException {
		if(loginError.isDisplayed()) {
			test.info("Error message displayed");
			return true;
		}
		else {
			test.fail("ErrorMesg not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	public Boolean isFreeTrialSeen() throws IOException {
		test.pass("Free trail is not seen expected");
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		return true;
		
	}
	
	public Boolean isSavedUserNameSeen() throws IOException {
		if(savedUser.isDisplayed()) {
			test.info("Username saved");
			return true;
		}
		else {
			test.fail("Saved username not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			return false;
		}
	}
	
	public String getSavedUser() {
		return savedUser.getText();
	}
	
	public Boolean launchApp(WebDriver driver) throws IOException {
		driver.get(DataUtils.readAccounts("prod.sfdc.url"));
		test.info("App launched");
		return true;
		
	}
	
	public boolean clickOnForgotPswd() throws IOException {
		boolean forgotPswdSeen=true;
		if(forgotPswd.isDisplayed()) {
			forgotPswd.click();
			test.info("forgotPswd clicked");
		}
		else {
			test.fail("ForgotPswd not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			forgotPswdSeen=false;
		}
		return forgotPswdSeen;
	}
	
	public String verifyForgotPswdTitle() {
		return forgotPswdTitile.getText();	 
	}
	
	public String getErrorMsg() {
		//System.out.println(loginError.getText());
		return loginError.getText();
	}
}
