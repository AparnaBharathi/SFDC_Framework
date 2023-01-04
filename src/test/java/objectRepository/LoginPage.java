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
			logger.info("Username visible");
			username.sendKeys(uname);
			logger.info("Username entered");
			test.info("UserName is entered");
			return true;
		}
		else {
			test.fail("Username not found");
			logger.error("Username not found");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
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
			logger.info("Password visible");
			password.sendKeys(pswd);
			logger.info("Password entered");
			test.info("Pswd entered");
			return true;
		}
		else {
			test.fail("Pswd not found");
			logger.error("password not visible");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
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
			logger.info("Login visible");
			login.click();
			logger.info("Login clicked");
			test.info("Clicked login");
			return true;
		}
		else {
			test.fail("Login not found");
			logger.error("Login not visible");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
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
			logger.info("rememberMe is visible");
			if(rememberMe.isSelected()) {
				selectRememberMe=true;
			}
			else {
				logger.info("rememberMe is visible");
				rememberMe.click();
				logger.info("rememberMe is clicked");
				selectRememberMe=true;
				test.info("RemeberMe is clicked");
			}
		}
		else {
			test.fail("RemeberMe not found");
			logger.info("rememberMe is not visible");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
		}
		return selectRememberMe;
	}
	
	public Boolean clearPasswd() {
		password.clear();
		logger.info("password is empty");
		test.info("Password empty");
		return true;
	}
	
	public Boolean isErrorMsgSeen() throws IOException {
		if(loginError.isDisplayed()) {
			logger.info("Errormessage is visible");
			test.info("Error message displayed");
			return true;
		}
		else {
			test.fail("ErrorMesg not found");
			logger.error("error is  not visible");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
			return false;
		}
	}
	
	public Boolean isFreeTrialSeen() throws IOException {
		test.fail("Free trail is not seen expected");
		logger.error("Free trial is not visible");
		test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
		logger.error("Screenshot captured");
		return false;
		
	}
	
	public Boolean isSavedUserNameSeen() throws IOException {
		if(savedUser.isDisplayed()) {
			logger.info("Username is saved");
			test.info("Username saved");
			return true;
		}
		else {
			test.fail("Saved username not found");
			logger.info("username is not saved");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
			return false;
		}
	}
	
	public String getSavedUser() {
		return savedUser.getText();
	}
	
	public Boolean launchApp(WebDriver driver) throws IOException {
		driver.get(DataUtils.readAccounts("prod.sfdc.url"));
		driver.manage().window().maximize();
		test.info("App launched");
		logger.info("app is launched");
		return true;
		
	}
	
	public boolean clickOnForgotPswd() throws IOException {
		boolean forgotPswdSeen=true;
		if(forgotPswd.isDisplayed()) {
			logger.info("forgotpswd is visible");
			forgotPswd.click();
			logger.info("forgotpswd is clicked");
			test.info("forgotPswd clicked");
		}
		else {
			test.fail("ForgotPswd not found");
			logger.info("forgotpswd is not visible");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
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
	
	public Boolean loginToSFDC() throws IOException {
		boolean isLoginSuccess =false;
		boolean appLaunh=launchApp(driver);
		if(appLaunh) {
			enterUsername(DataUtils.readAccounts("valid.username"));
			enterPswd(DataUtils.readAccounts("valid.password"));
			clickLogin();
			isLoginSuccess=true;
			test.info("Login success");
			logger.info("Login success");
		}
		else {
			test.fail("Login failed");
			logger.info("Login failed");
			test.addScreenCaptureFromPath(Utilities.captureScreenshot(driver));
			logger.error("Screenshot captured");
		}
		return isLoginSuccess;
	}
}
