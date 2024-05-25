package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseClass {
	public WebDriver driver;
	// public ChromeDriver driver;
	// public EdgeDriver driver;
	// public FirefoxDriver driver;
	public HomePage homePage;

	@BeforeMethod
	public void setUp() {
		// For Chrome Driver
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// For Edge Driver
//		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
//		driver = new EdgeDriver();
		
		// For Firefox Driver
//		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
//		driver = new FirefoxDriver();
		
		// When physical driver absent, or driver is not  working because of version issue, then you can use webdrivermanager
		// webdriver manager doesn't need any physical driver
		// From below line, the most updated version of chrome browser will be initialized, when no version is mentioned	
		
		/*
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		*/
			
		// my present version: 124.0.6367.210
		// stable version: 125.0.6422.78
		// older version sometimes used for stability of browser, sometime the request from the Authority
		// if you choose version, then it will use that specific version of driver
		/*
		WebDriverManager.chromedriver().driverVersion("122.0.6261.69").setup();
		driver = new ChromeDriver();
		*/
		
		/*
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		*/
		
		/*
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		*/
	
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
