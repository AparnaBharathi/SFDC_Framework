package testScript;

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
	
	@BeforeMethod
	public void setDriver() {
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
	}
	public static WebDriver getBrowserType(String browser) {
		String browserName=browser.toLowerCase();
		WebDriver driver=null;
		switch (browserName) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}
		case "safari": {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
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
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	
	
	public static void configureExtentReport() {
		String reportPath=System.getProperty("user.dir")+"/src/test/java/reports/sfdc.html";
		extent=new ExtentReports();
		ExtentSparkReporter sparkHtml=new ExtentSparkReporter(reportPath);
		extent.attachReporter(sparkHtml);
	}
}
