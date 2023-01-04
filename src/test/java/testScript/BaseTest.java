package testScript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<WebDriver>();
	public static ExtentReports extent=null;
	protected static Logger logger=LogManager.getLogger();
	
	@BeforeMethod
	public void setDriver() {
		logger.info("setDriver() Driver configuration is success");
		WebDriver driver=BaseTest.getBrowserType("chrome");
		threadLocalDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	@AfterMethod
	public void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
		logger.info("removeDriver() success");
	}
	public static WebDriver getBrowserType(String browser) {
		String browserName=browser.toLowerCase();
		WebDriver driver=null;
		switch (browserName) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			logger.info("chromeDriver() setUp complete");
			break;
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("firefoxdriver() setUp complete");
			break;
		}
		case "safari": {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			logger.info("safaridriver() setUp complete");
			break;
		}
		default:
			System.out.println("Browser not supported");
			break;
		}
		return driver;
	}
	
	@BeforeSuite
	public void setUp() {
		configureExtentReport();
		logger.info("setUp() success");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		logger.info("tearDown() success");
	}
	
	
	public static void configureExtentReport() {
		logger.info("configureExtentReport() initiated");
		String reportPath=System.getProperty("user.dir")+"/src/test/java/reports/sfdc.html";
		extent=new ExtentReports();
		ExtentSparkReporter sparkHtml=new ExtentSparkReporter(reportPath);
		extent.attachReporter(sparkHtml);
		logger.info("configureExtentReport() success");
	}
}
