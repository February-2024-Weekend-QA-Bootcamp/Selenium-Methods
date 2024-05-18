package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseClass {
	// Why default type is not ok for below 2 line? 
	// because different package accessibility is not possible for default type
	public WebDriver driver; // or we can use protected type
	public HomePage homePage; // or we can use protected type

	// Before start a test what need to do?
	@BeforeMethod
	public void setUp() {
		// First job is to recognize the location of driver from your device
		// right click on chromedriver.exe/chromedriver --- properties -- copy the location an paste below
		// System is a Java class and setProperty is a method of System Class
		// 1st way, to show the location of chrome driver
		// This is an absolute path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tofael\\eclipse-workspace\\gov.cms.portal.february\\driver\\chromedriver.exe");
		// We instantiated the driver here
		driver = new ChromeDriver();
		// maximize method is used to maximize the window -- mostly used
		driver.manage().window().maximize();
		// deleteAllCookies do delete the cookies
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
		// PageLoadTimeout is used to wait to load the page for curtain amount of time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		// Implicitly wait is used to wait for each web element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homePage = new HomePage(driver);
	}
	
	// After ending a test what need to do?
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
